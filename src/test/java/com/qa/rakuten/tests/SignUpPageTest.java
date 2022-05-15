package com.qa.rakuten.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.rakuten.pages.SignUpPage;
import com.qa.rakuten.pages.WelcomePage;
import com.qa.rakuten.testbase.TestBase;

public class SignUpPageTest extends TestBase{
	
	public SignUpPageTest() {
		super();
	}
	
	WelcomePage welcomePage;
	SignUpPage signUpPage;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		initialize();
		welcomePage = new WelcomePage();
		welcomePage.verifyWelcomePagePrivacyOption();
		signUpPage = welcomePage.verifyJoinRakutenButton();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void one() {
		signUpPage.createNewAccount("pixiee1", "duster", "pixieduster1@duste.com", "Distressmemphis1!");
	}

}
