package resources;

import java.io.*;
import java.util.Properties;

import com.yacout.seleniumUI.tests.AmazonTest;

public class Utilities {
	public static Properties loadTestData() throws IOException {
		Properties properties = new Properties();
		InputStream inputStream = AmazonTest.class.getClassLoader().getResourceAsStream("resources/testdata.properties");
		if (inputStream != null) {
			properties.load(inputStream);
			inputStream.close();
		} else {
			throw new FileNotFoundException("testdata.properties not found");
		}
		return properties;
	}
}
