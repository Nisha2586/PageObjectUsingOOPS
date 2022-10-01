package com.TestPages;


	import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import com.MyPages.AbstractPage;
import com.MyPages.BasePage;

import utilPages.Readconfig;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


	public class TestBase {
		 WebDriver driver;
		 public AbstractPage absPage;
		Readconfig read = new Readconfig();
		
	@BeforeClass
	public void setUp() {
		if (read.getBrowser().equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",read.getChromeBrowserPath() );
			driver = new ChromeDriver();
		}
		else if(read.getBrowser().equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",read.getFireFoxBrowserPath());
			driver = new FirefoxDriver();		
		}
		else  {
			System.setProperty("webdriver.ie.driver",read.getIEBrowserPath());
			driver = new InternetExplorerDriver();		
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(read.getBaseUrl());
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		absPage = new BasePage(driver);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
		
		

	

}
