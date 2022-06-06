package com.solcallservices.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase(){
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("/Users/bitbyte/eclipse-workspace/solcallservices/src/main/java/com/solcallservices/qa/config/config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {


		}

	}
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","/Users/bitbyte/Desktop/version103/chromedriver");
			driver=new ChromeDriver();

		}else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver","/Users/bitbyte/Desktop/gicko\\ driver//geckodriver");
	driver=new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url")  );


	}

}
