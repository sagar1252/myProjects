package basepages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {
	private static Properties prop;

	public static void initilisation() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"D:\\workspace\\proejcts\\testvagrantprohect\\src\\main\\java\\testvagrantconfig\\config");
		prop.load(fis);
	}

	static {
		try {
			initilisation();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getProperty(String property) {

		return prop.getProperty(property);
	}

}
