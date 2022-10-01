/**
 * 
 */
package com.MyPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.*;

/**
 * @author NISHA
 *
 */
public class TechFiosTestPage extends BasePage {

	public TechFiosTestPage(WebDriver driver) {
		super(driver);
	}

	// page locators
	private By Header_locator = By.id("label-first");
	private By ADD_CATEGORY_INSERT_ELEMENT=By.xpath( "//*[@id='extra']/input[1]");
	private By ADD_CATEGORY_BUTTON_ELEMENT=By.xpath( "//*[@id=\"extra\"]/input[2]");
	private By SELECT_CATEGORY_DROPDOWN=By.cssSelector( "select[name='category']");
	

//	@FindBy(how = How.CSS, using = "input[name='categorydata']")
//	WebElement ADD_CATEGORY_INSERT_ELEMENT;
//	@FindBy(how = How.CSS, using ="input[name='submit'][value='Add category']" )
//	WebElement ADD_CATEGORY_BUTTON_ELEMENT;


	// Public getters

	public String getTestPageTitle() {
		return getPageTitle();
	}
	public WebElement getHeader() {
		return getElement(Header_locator);
	}

	public String getTestPageHeader() {
		return getPageHeader(Header_locator);
	}
	public WebElement getAddCategoryWebElement() {
		return getElement(ADD_CATEGORY_INSERT_ELEMENT);
	}
	public WebElement getAddCategoryButtonElement() {
		return getElement(ADD_CATEGORY_BUTTON_ELEMENT);
	}
	public WebElement selectDropDownElement() {
		return getElement(SELECT_CATEGORY_DROPDOWN);
	}

	
	// Intractable methods
	public void insertAddCategory(String categoryName,int outBound) throws InterruptedException {
		String addedCategory=createRandomString(categoryName,outBound);
		Thread.sleep(5000);
		getAddCategoryWebElement().sendKeys(addedCategory);
	}

	public TechFiosTestPage clickAddCategoryButton() {
		getAddCategoryButtonElement().click();
		return getInstance(TechFiosTestPage.class);
	}

	public boolean validateaddCatogeryDisplayed(String inputText) {
		List<WebElement> allcategoryList = selectorDropDownList(selectDropDownElement(), inputText);
		for (int i = 0; i < allcategoryList.size(); i++) {
			if (allcategoryList.get(i).equals(inputText)) {
				System.out.println("The Category added to the list is : " + i);
				break;
			}
			return true;
		}
		return false;
	}

}
