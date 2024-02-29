package com.ascii.reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AsciiFileReader {
	
	public InputStream getFileFromResourceAsStream (String fileName) {
		
		try {
			File initialFile = new File(fileName);
			InputStream tragetSteam = new FileInputStream(initialFile);
			return tragetSteam;
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Character> readInputStream(InputStream is) {
		List<Character> data = new ArrayList<Character>();
		
		try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader reader = new BufferedReader(streamReader)) {
			
			String line;
			while( (line = reader.readLine() ) != null) {
				data.add((char) Integer.parseInt(line));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public void writeData(List<Character> data , String fileName , boolean doReverse) {
		File file = new File(fileName);
		
		try (FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw); ) {

			if(!file.exists()) {
				file.createNewFile();
			}
			
			if(doReverse) {
				Collections.reverse(data);
			}
			
			for (Character info : data) {
				bw.write(info);
				bw.write("\n");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
