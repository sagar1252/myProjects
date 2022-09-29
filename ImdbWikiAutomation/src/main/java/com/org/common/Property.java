package com.org.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class Property {
	private static Properties prop;

	public static void initilisation() throws IOException, URISyntaxException {
		prop = new Properties();

		ClassLoader classloader = Thread.currentThread().getContextClassLoader();

		File file = new File(classloader.getResource("config").toURI());
		FileInputStream input = new FileInputStream(file);

		prop.load(input);
	}

	static {
		try {
			initilisation();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getProperty(String property) {

		return prop.getProperty(property);
	}

}
