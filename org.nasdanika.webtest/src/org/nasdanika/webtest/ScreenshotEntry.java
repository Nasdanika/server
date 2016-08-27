package org.nasdanika.webtest;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.reflect.Member;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;

import javax.imageio.ImageIO;

import org.json.JSONObject;
import org.nasdanika.html.impl.DefaultHTMLFactory;
import org.nasdanika.webtest.model.ScreenshotType;

/**
 * Compares current screenshot with the previous, writes to file if different.
 * @author Pavel Vlasov
 *
 */
public class ScreenshotEntry implements Runnable, HttpPublisher, DirectoryPublisher, Comparable<ScreenshotEntry> {
		
	private Screenshot.When when;
	
	private int seqNo;
	
	public int getSeqNo() {
		return seqNo;
	}

	public Screenshot.When getWhen() {
		return when;
	}
	
	private String comment;
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getComment() {
		return comment;
	}
	
	private String id;
	
	public String getId() {
		return id;
	}
	
	ScreenshotEntry master;
	
	public ScreenshotEntry getMaster() {
		return master==null ? this : master.getMaster();
	}
	
	public boolean isMaster() {
		return master==null;
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

	final OperationResult<?,?> operationResult;
	
	public OperationResult<?,?> getOperationResult() {
		return operationResult;
	}

	ScreenshotEntry(
			OperationResult<?,?> operationResult,
			Screenshot.When when,
			ScreenshotEntry prev, 
			File screenshotsDir, 
			String id, 
			byte[] bytes) {
		
		this.operationResult = operationResult;
		this.screenshotsDir = screenshotsDir;
		this.id = id;
		this.bytes = bytes;
		this.bytesRef = new SoftReference<byte[]>(bytes);
		this.prev = prev;
		if (prev != null) {
			seqNo = prev.seqNo + 1;
		}
		this.when = when;
	}

	/**
	 * @param se
	 * @return true if this screenshot entry is before the parameter screenshot entry. 
	 */
	public boolean isBefore(ScreenshotEntry se) {		
		if (se==null || se.prev == null) {
			return false;
		}
		if (se.prev == this) {
			return true;
		}
		return isBefore(se.prev);
	}
	
	@Override
	public int compareTo(ScreenshotEntry o) {
		if (o == this) {
			return 0;
		}
		
		if (isBefore(o)) {
			return -1;
		}
		
		if (o.isBefore(this)) {
			return 1;
		}
		
		return 0;
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
	
	@Override
	public String publish(
			Directory directory, 
			boolean publishPerformance, 
			Map<Object, String> idMap,
			DirectoryPublishMonitor monitor) throws Exception {
		
		if (master==null && !idMap.containsKey(this)) {
			String path = "screenshots/"+getScreenshotFile().getName();
			if (monitor!=null) {
				monitor.onPublishing("Screenshot"+getTextCaption(), path);
			}
			idMap.put(this, path);
			JSONObject info = new JSONObject();
			info.put("height", getHeight());
			info.put("width", getWidth());
			info.put("type", "image/png");
			directory.store(info, path+".json");
			directory.store(getScreenshotFile(), path+".png");
			return path;
		}
		
		return null;
	}

	public org.nasdanika.webtest.model.Screenshot toScreenshotModel(File screenshotsDir, Map<Object, Object> objectMap) {
		org.nasdanika.webtest.model.Screenshot screenshotModel = org.nasdanika.webtest.model.ModelFactory.eINSTANCE.createScreenshot();
		screenshotModel.setContentType("image/png");
		screenshotModel.setHeight(getHeight());
		long counter = 0;
		File screenshotFile = new File(screenshotsDir, "screenshot_"+Long.toString(counter, Character.MAX_RADIX)+".png");
		while (screenshotFile.exists()) {
			screenshotFile = new File(screenshotsDir, "screenshot_"+Long.toString(++counter, Character.MAX_RADIX)+".png");
		}
		try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream(getScreenshotFile())); BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(screenshotFile))) {
			for (int data = fis.read(); data!=-1; data = fis.read()) {
				out.write(data);
			}					
		} catch (IOException e) {
			throw new WebTestException("Error writing screenshot", e);
		}
		screenshotModel.setLocation(screenshotsDir.getName()+"/"+screenshotFile.getName());
		screenshotModel.setWidth(getWidth());
		
		objectMap.put(getMaster(), screenshotModel);
		return screenshotModel;
	}
	
	public org.nasdanika.webtest.model.ScreenshotEntry toScreenshotEntryModel(Map<Object, Object> objectMap) {
		org.nasdanika.webtest.model.Screenshot screenshot = (org.nasdanika.webtest.model.Screenshot) objectMap.get(getMaster());
		if (screenshot==null) {
			throw new IllegalStateException("Screenshot not found in the object map");
		}
		org.nasdanika.webtest.model.ScreenshotEntry modelScreenshotEntry = org.nasdanika.webtest.model.ModelFactory.eINSTANCE.createScreenshotEntry();
		modelScreenshotEntry.setComment(getComment());
		modelScreenshotEntry.setType(ScreenshotType.valueOf(getWhen().name()));				
		modelScreenshotEntry.setScreenshot(screenshot);
		return modelScreenshotEntry;
	}	

}
