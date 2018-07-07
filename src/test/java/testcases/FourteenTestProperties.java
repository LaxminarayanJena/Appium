package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FourteenTestProperties {

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Conf.Properties");
        prop.load(fis);
        System.out.println(prop.getProperty("device.name"));
	}

}
