package com.qa.rakuten.tests;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.rakuten.pages.WelcomePage;
import com.qa.rakuten.testbase.TestBase;

public class WelcomePageTest extends TestBase{
	
	WelcomePage welcomePage;
	
	
	
	public WelcomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException {
		initialize();
		welcomePage = new WelcomePage();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void welcomePagePrivacyAcceptTest() {
		Assert.assertTrue(welcomePage.verifyWelcomePagePrivacyOption());
	}
	
	@Test(priority = 2)
	public void welcomePageClickOnJoinButtonTest() throws InterruptedException, IOException {
		welcomePage.verifyWelcomePagePrivacyOption();
		welcomePage.verifyJoinRakutenButton();
	}
	

}
