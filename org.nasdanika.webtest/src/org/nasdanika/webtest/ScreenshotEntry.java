package org.nasdanika.webtest;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.nasdanika.html.impl.DefaultHTMLFactory;

/**
 * Compares current screenshot with the previous, writes to file if different.
 * @author Pavel Vlasov
 *
 */
public class ScreenshotEntry implements Runnable {
	
	final String id;
	
	public String getId() {
		return id;
	}
	
	ScreenshotEntry master;
	
	public ScreenshotEntry getMaster() {
		return master==null ? this : master.getMaster();
	}
	
	private byte[] bytes;

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

	final OperationResult operationResult;
	
	public OperationResult getMethodResult() {
		return operationResult;
	}

	ScreenshotEntry(OperationResult operationResult, ScreenshotEntry prev, File screenshotsDir, String id, byte[] bytes) {
		this.operationResult = operationResult;
		this.screenshotsDir = screenshotsDir;
		this.id = id;
		this.bytes = bytes;
		this.prev = prev;
	}

	@Override
	public void run() {
		if (prev==null) {
			try {
				BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
				if (image!=null) {
					width = image.getWidth();
					height = image.getHeight();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			if (Arrays.equals(prev.getMaster().bytes, bytes)) {
				master = prev.getMaster();
				bytes = null;
				return;
			}
		}
		try {
			screenshotFile = new File(screenshotsDir, "screenshot_"+id+".png");
			try (FileOutputStream fos = new FileOutputStream(screenshotFile)) {
				fos.write(bytes);
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
				caption.append(ReportGenerator.title(operationResult.getName()));
			} else {
				caption.append(mTitle.value());
			}
		}
		return caption.toString();
	}
		
}
