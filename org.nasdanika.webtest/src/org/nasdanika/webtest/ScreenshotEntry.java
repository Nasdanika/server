package org.nasdanika.webtest;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;

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

	private ScreenshotEntry prev;

	ScreenshotEntry(ScreenshotEntry prev, File screenshotsDir, String id, byte[] bytes) {
		this.screenshotsDir = screenshotsDir;
		this.id = id;
		this.bytes = bytes;
		this.prev = prev;
	}

	@Override
	public void run() {
		if (prev!=null) {
			if (Arrays.equals(prev.getMaster().bytes, bytes)) {
				master = prev.getMaster();
				bytes = null;
				return;
			}
		}
		try {
			screenshotFile = new File(screenshotsDir, "screenshort_"+id+".png");
			try (FileOutputStream fos = new FileOutputStream(screenshotFile)) {
				fos.write(bytes);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
}
