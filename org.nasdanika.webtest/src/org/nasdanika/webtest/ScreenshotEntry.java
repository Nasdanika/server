package org.nasdanika.webtest;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.reflect.Member;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;

import javax.imageio.ImageIO;

import org.nasdanika.html.impl.DefaultHTMLFactory;

/**
 * Compares current screenshot with the previous, writes to file if different.
 * @author Pavel Vlasov
 *
 */
public class ScreenshotEntry implements Runnable, HttpPublisher {
	
	private String id;
	
	public String getId() {
		return id;
	}
	
	ScreenshotEntry master;
	
	public ScreenshotEntry getMaster() {
		return master==null ? this : master.getMaster();
	}
	
	private byte[] bytes;
	
	private Reference<byte[]> bytesRef;
	
	private byte[] getBytes() throws Exception {
		if (bytes!=null) {
			return bytes;
		}
		byte[] ret = bytesRef.get();
		if (ret!=null) {
			return ret;
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(screenshotFile)); BufferedOutputStream out = new BufferedOutputStream(baos)) {
			for (int data = in.read(); data!=-1; data=in.read()) {
				out.write(data);
			}
		}
		bytesRef = new SoftReference<byte[]>(ret);
		return ret;
	}

	private File screenshotsDir;
	
	private File screenshotFile;
	
	public File getScreenshotFile() {
		return screenshotFile;
	}
	
	private int width;
	private int height;
	
	public int getWidth() {
		return prev==null ? width : prev.getWidth();
	}
	
	public int getHeight() {
		return prev==null ? height : prev.getHeight();
	}

	private ScreenshotEntry prev;

	final OperationResult<?> operationResult;
	
	public OperationResult<?> getOperationResult() {
		return operationResult;
	}

	ScreenshotEntry(OperationResult<?> operationResult, ScreenshotEntry prev, File screenshotsDir, String id, byte[] bytes) {
		this.operationResult = operationResult;
		this.screenshotsDir = screenshotsDir;
		this.id = id;
		this.bytes = bytes;
		this.bytesRef = new SoftReference<byte[]>(bytes);
		this.prev = prev;
	}

	@Override
	public void run() {
		try {
			if (prev==null) {
				BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
				if (image!=null) {
					width = image.getWidth();
					height = image.getHeight();
				}
			} else {
				if (Arrays.equals(prev.getMaster().getBytes(), bytes)) {
					master = prev.getMaster();
					bytes = null;
					return;
				}
			}
			screenshotFile = new File(screenshotsDir, "screenshot_"+id+".png");
			try (FileOutputStream fos = new FileOutputStream(screenshotFile)) {
				fos.write(bytes);
			} finally {
				bytes = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	String getHTMLCaption() {
		if (operationResult==null) {
			return id;
		}
		return operationResult.getHTMLCaption(new DefaultHTMLFactory());
	}
	
	String getTextCaption() {
		StringBuilder caption = new StringBuilder();
		if (operationResult instanceof TestMethodResult) {
			caption.append("[Test] ");
		} else if (operationResult instanceof ActorMethodResult) {
			caption.append("[Actor] ");
		} else if (operationResult instanceof PageMethodResult) {
			caption.append("[Page] ");
		}
		if (operationResult!=null) {
			Class<?> dc = operationResult.operation instanceof Member ? ((Member) operationResult.operation).getDeclaringClass() : null;
			caption.append(ReportGenerator.classTitle(dc));
			caption.append(" :: ");
			Title mTitle = operationResult.operation.getAnnotation(Title.class);
			if (mTitle==null) {
				caption.append(WebTestUtil.title(operationResult.getName()));
			} else {
				caption.append(mTitle.value());
			}
		}
		return caption.toString();
	}
	
	@Override
	public void publish(
			URL url, 
			String securityToken, 
			boolean publishPerformance,
			Map<Object, String> idMap, 
			PublishMonitor monitor) throws Exception {
		
		if (master==null && !idMap.containsKey(this)) {
			if (monitor!=null) {
				monitor.onPublishing("Screenshot"+getTextCaption(), url);
			}
			HttpURLConnection pConnection = (HttpURLConnection) url.openConnection();
			pConnection.setRequestMethod("POST");
			pConnection.setDoOutput(true);
			pConnection.setRequestProperty("Authorization", "Bearer "+securityToken);
			pConnection.setRequestProperty("Content-Type", "image/png");
			pConnection.setRequestProperty("Height", String.valueOf(getHeight()));
			pConnection.setRequestProperty("Width", String.valueOf(getWidth()));
			try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream(getScreenshotFile())); BufferedOutputStream out = new BufferedOutputStream(pConnection.getOutputStream())) {
				for (int data = fis.read(); data!=-1; data = fis.read()) {
					out.write(data);
				}					
			}
			int responseCode = pConnection.getResponseCode();
			if (responseCode==HttpURLConnection.HTTP_OK) {
				id = pConnection.getHeaderField("ID");
				idMap.put(this, id);
			} else {
				throw new PublishException(url+" error: "+responseCode+" "+pConnection.getResponseMessage());
			}
		}
	}			
	
	@Override
	public int publishSize() {
		return master==null ? 1 : 0;
	}				
		
}
