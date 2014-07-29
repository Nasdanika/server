package org.nasdanika.webtest;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.nasdanika.html.impl.DefaultHTMLFactory;

/**
 * Compares current screenshot with the previous, writes to file if different.
 * @author Pavel Vlasov
 *
 */
class ScreenshotEntry implements Runnable {
	
	final String id;
	
	ScreenshotEntry master;
	
	ScreenshotEntry getMaster() {
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

	final MethodResult methodResult;

	ScreenshotEntry(MethodResult methodResult, ScreenshotEntry prev, File screenshotsDir, String id, byte[] bytes) {
		this.methodResult = methodResult;
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
		if (methodResult==null) {
			return id;
		}
		return methodResult.getHTMLCaption(new DefaultHTMLFactory());
	}
	
	String getTextCaption() {
		StringBuilder caption = new StringBuilder();
		if (methodResult instanceof TestMethodResult) {
			caption.append("[Test] ");
		} else if (methodResult instanceof ActorMethodResult) {
			caption.append("[Actor] ");
		} else if (methodResult instanceof PageMethodResult) {
			caption.append("[Page] ");
		}
		if (methodResult!=null) {
			Class<?> dc = methodResult.method.getDeclaringClass();
			Title classTitle = dc.getAnnotation(Title.class);
			if (classTitle==null) {
				caption.append(ReportGenerator.classTitle(dc));
			} else {
				caption.append(classTitle.value());
			}
			caption.append(" :: ");
			Title mTitle = methodResult.method.getAnnotation(Title.class);
			if (mTitle==null) {
				caption.append(ReportGenerator.title(methodResult.method.getName()));
			} else {
				caption.append(mTitle.value());
			}
		}
		return caption.toString();
	}
	
	
}
