package com.ascii.reader;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AsciiFileReaderTest {

	@InjectMocks
	AsciiFileReader asciiFileReader;
	
	@Test
	public void getFileFromResourceAsStream() throws Exception {
		
		URL resource = this.getClass().getResource("/asciiFile.txt");
		
		File file = Paths.get(resource.toURI()).toFile();
		
		try (InputStream result = asciiFileReader.getFileFromResourceAsStream(file.getAbsolutePath())) {
			
			List<Character> data = asciiFileReader.readInputStream(result);
			Assertions.assertEquals(4 ,  data.size());
		}
	}
	
	@Test
	public void redInputStream() throws Exception {
	
		try(InputStream input = this.getClass().getResourceAsStream("/asciiFile.txt")) {
			List<Character> data = asciiFileReader.readInputStream(input);
			Assertions.assertEquals(4 ,  data.size());
		}
	}
	
	@Test
	public void writeData() {
		List<Character> data = new ArrayList<>();

		data.add('a');
		data.add('b');
		data.add('c');
		data.add('d');
		
		final String fileName = "src/test/resources/resultFile.txt";
		asciiFileReader.writeData(data, fileName, false);
		
		File file = new File(fileName);
		Assertions.assertEquals(true ,  file.exists());
		file.delete();
	
	}
}
