package com.qa.rakuten.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.rakuten.pages.HomePage;
import com.qa.rakuten.pages.SignUpPage;
import com.qa.rakuten.pages.WelcomePage;
import com.qa.rakuten.testbase.TestBase;

public class HomePageTest extends TestBase{

	public HomePageTest() {
		super();
	}

	WelcomePage welcomePage;
	SignUpPage signUpPage;
	HomePage homePage;

	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		initialize();
		welcomePage = new WelcomePage();
		welcomePage.verifyWelcomePagePrivacyOption();
		signUpPage = welcomePage.verifyJoinRakutenButton();
		homePage = signUpPage.createNewAccount("droovy1", "deee1", "droovy1deee94a@deee1.com", "Astronized1!");

	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyName() throws IOException {
		//Assert.assertEquals(homePage.getUserName(), "droovy1");
		
	}

}
