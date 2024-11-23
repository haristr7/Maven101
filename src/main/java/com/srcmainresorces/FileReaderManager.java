package com.srcmainresorces;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.junit.Assert;

public class FileReaderManager {
	private static Properties property;
	private static FileInputStream fileinputstream;

	private static void setupProperty() {
		if (property == null) {
			File file = new File("D:\\MavenProject\\src\\main\\java\\com\\srcmainresorces\\loginpage.properties");
			try {
				fileinputstream = new FileInputStream(file);
				property = new Properties();
				property.load(fileinputstream);
			} catch (FileNotFoundException e) {
				Assert.fail("ERROR IN LOADING FILE");
			} catch (Exception e) {
				Assert.fail("Error In Loading File");
			}
		}

	}

	public static String getDataProperty(String dataValue) {
		setupProperty();
		String inputdata = property.getProperty(dataValue);
		return inputdata;
	}
}