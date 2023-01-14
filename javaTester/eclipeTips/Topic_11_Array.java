package eclipeTips;

import org.testng.annotations.Test;

import commons.GlobalConstants;

public class Topic_11_Array {

	@Test
	public void TC_06() {
		String[] fileNames = {"Dream.png", "Image.png", "Life.png"};
		String filePath = GlobalConstants.UPLOAD_FILE;
		String fullFileName = "";
		for (String file: fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		System.out.println(fullFileName);
	}
}
