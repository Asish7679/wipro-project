package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	public static void loadConfig() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
		prop.load(fis);
	}

	public static String get(String key) {
		return prop.getProperty(key);
	}
}
