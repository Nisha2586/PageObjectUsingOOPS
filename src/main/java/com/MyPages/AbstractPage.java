package com.MyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
	
	WebDriver driver;
	WebDriverWait explicitWait;
	
	public AbstractPage(WebDriver driver){
		this.driver=driver;
		this.explicitWait = new WebDriverWait(this.driver,15);
		}
	
	//abstract methods
	public abstract String getPageTitle();
	public abstract String getPageHeader(By locator);
	public abstract WebElement getElement(By locator);
	public abstract void waitForElementPresent(WebElement element);
	public abstract void waitForPageTitle(String title);
	
	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
		return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//	public <E> void arr(E[] arr) {
//	for(E num :arr) {
//		System.out.println(num);
//	}
//	}

}
