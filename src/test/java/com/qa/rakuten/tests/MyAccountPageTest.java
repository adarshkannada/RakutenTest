package com.qa.rakuten.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.rakuten.pages.HomePage;
import com.qa.rakuten.pages.MyAccountPage;
import com.qa.rakuten.pages.SignUpPage;
import com.qa.rakuten.pages.WelcomePage;
import com.qa.rakuten.testbase.TestBase;

public class MyAccountPageTest extends TestBase{
	
	public MyAccountPageTest() {
		super();
	}
	
	WelcomePage welcomePage;
	SignUpPage signUpPage;
	HomePage homePage;
	MyAccountPage myAccountPage;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		initialize();
		welcomePage = new WelcomePage();
		welcomePage.verifyWelcomePagePrivacyOption();
		signUpPage = welcomePage.verifyJoinRakutenButton();
		homePage = signUpPage.createNewAccount("droovy1", "deee1", "droovy1deee94a3@deee1.com", "Astronized1!");
		myAccountPage = homePage.goToMyAccountOption();
		
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyName() throws IOException {
		myAccountPage.selectPointsActivity();
		
	}
}
