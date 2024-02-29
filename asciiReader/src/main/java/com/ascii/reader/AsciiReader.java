package com.ascii.reader;

import java.io.InputStream;
import java.util.List;

public class AsciiReader {
	
	public static void main(String[] srgs) {
		
		AsciiFileReader reader = new AsciiFileReader();
		InputStream inputStream = reader.getFileFromResourceAsStream(Constants.INPUT_FILE_NAME);
		
		if(inputStream != null) {
			List<Character> data = reader.readInputStream(inputStream);
			reader.writeData(data, Constants.OUTPUT_FILE_NAME, true);
			
		}
		
	}

}
