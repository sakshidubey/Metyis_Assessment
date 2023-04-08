package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	private static Properties properties;
	
	/**
     * This function is used to load properties file based on environment variable passed at runtime.
     */
	public static void loadData() throws IOException {
		properties = new Properties();
		String env = System.getProperty("environment");
		try {
			File f = new File(
					System.getProperty("user.dir") + "/src/test/resources/properties/" + env + "-config.properties");
			FileReader obj = new FileReader(f);
			properties.load(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	/**
     * This function is used to get url from properties file.
     * @return: String
     */
	public static String getApplicationUrl() throws IOException {
//		loadData();
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the properties file.");
	}
}
