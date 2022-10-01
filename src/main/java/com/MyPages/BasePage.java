package com.MyPages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BasePage extends AbstractPage{

	public BasePage(WebDriver driver) {
		super(driver);
		}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {//wrapper function
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			return element;
		}catch(Exception e) {
			System.out.println("Some error occured while creating element :" + locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElementPresent(WebElement element) {
		try {
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Exception e) {
			System.out.println("Some error occured while waiting for the element :" + element.toString());
			e.printStackTrace();
		}
		
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			explicitWait.until(ExpectedConditions.titleContains(title));
			}catch(Exception e) {
				System.out.println("Some error occured while waiting for the element :" +title);
				e.printStackTrace();
			}	
		
	}
	public static List<WebElement> selectorDropDownList(WebElement element,String inputText ) {
	Select select = new Select(element);
		select.selectByVisibleText(inputText);
		select.getOptions();
		return select.getAllSelectedOptions();
		}
	public int randomGenNum(int boundaryNum) {
		return new Random().nextInt(boundaryNum);
	}
	public String createRandomString(String categoryName,int outBound) {
		return (categoryName+randomGenNum(outBound));
	}

}
