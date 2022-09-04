package com.automation.testutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase
{ 
	public static WebDriver driver;
	public static Properties prop;
	public static Actions action;
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 60;

	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/configuration/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization() 
	{
		if(prop.getProperty("browsername").equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "/Users/arunsingh/Downloads/geckodriver");	
			driver = new FirefoxDriver();
		}
		else if(prop.getProperty("browsername").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/arunsingh/Downloads/chromedriver");	
			driver = new ChromeDriver();
			
		}
		else
		{
			System.out.println("please give correct browser name");
		}

		 action = new Actions(driver);	
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		 driver.get(prop.getProperty("applicationurl"));
	} 
     
}
 

