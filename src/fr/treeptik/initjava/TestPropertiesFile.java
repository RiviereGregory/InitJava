package fr.treeptik.initjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestPropertiesFile {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileReader(new File("application.properties")));
		
		String property = properties.getProperty("application.conf.date.pattern");
		System.out.println(property);
		

	}

}
