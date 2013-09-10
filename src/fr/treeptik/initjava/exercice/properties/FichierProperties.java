package fr.treeptik.initjava.exercice.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class FichierProperties {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileReader(new File("application.properties")));
		Set<Object> keySet = properties.keySet();
		for (Object object : keySet) {
			System.out.println(object);
			System.out.println(properties.getProperty((String)object));
		}
		
		

	}

}
