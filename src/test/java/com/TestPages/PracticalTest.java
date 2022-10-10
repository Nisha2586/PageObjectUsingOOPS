package com.TestPages;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyPages.TechFiosTestPage;



public class PracticalTest extends TestBase{
	
	@Test(priority =0)
	public void verifyTestPageTitle() {
	String title=absPage.getInstance(TechFiosTestPage.class).getTestPageTitle();
	System.out.println(title);
	Assert.assertEquals("wrong title", title, "NSS-TODO List v 1.1");
	}
	
	@Test(priority =1)
	public void verifyTestPageHeader() {
		String header =absPage.getInstance(TechFiosTestPage.class).getTestPageHeader();
		System.out.println(header);
		Assert.assertEquals("wrong page", header, "NSS-TODO List v 1.1");
	}
	
	@Test(priority =2)
	@Parameters({"inputCategory","outbound"})
	public void addNewCategory(String inputCategory,int outbound){
		
		try {
			absPage.getInstance(TechFiosTestPage.class).insertAddCategory(inputCategory,outbound);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		absPage.getInstance(TechFiosTestPage.class).clickAddCategoryButton();
//		TechFiosTestPage tfTP = 
//		String sameHeader=tfTP.getTestPageHeader();
//		Assert.assertEquals(sameHeader, "NSS-TODO List v 1.1", "wrong page");
//		boolean val = absPage.getInstance(TechFiosTestPage.class).validateaddCatogeryDisplayed(inputCategory);
//		System.out.println(val);
	} 
	
	@Test(priority =4)
	@Parameters("inputCategory")
	public void verifyAddAndDisplayCategory(String inputCategory) {
		boolean val = absPage.getInstance(TechFiosTestPage.class).validateaddCatogeryDisplayed(inputCategory);
		Assert.assertEquals(val, true, "Added Category Displayed");
	}
}
