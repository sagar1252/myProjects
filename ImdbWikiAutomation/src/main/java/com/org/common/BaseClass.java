package com.org.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;

	public BaseClass() {
		String driverName = Property.getProperty("driver.name");
		System.setProperty(driverName, Property.getProperty("driver.path"));

		if (driverName.contains("gecko")) {

			driver = new FirefoxDriver();
		} else if (driverName.contains("chrome")) {

			driver = (WebDriver) new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

}
