package com.qa.rakuten.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.rakuten.pages.HomePage;
import com.qa.rakuten.pages.MyAccountPage;
import com.qa.rakuten.pages.PointsActivityPage;
import com.qa.rakuten.pages.SignUpPage;
import com.qa.rakuten.pages.WelcomePage;
import com.qa.rakuten.testbase.TestBase;


public class PointsActivityPageTest extends TestBase{
	public PointsActivityPageTest() {
		super();
	}
	
	
	WelcomePage welcomePage;
	SignUpPage signUpPage;
	HomePage homePage;
	MyAccountPage myAccountPage;
	PointsActivityPage pointsActivityPage;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		
		initialize();
		
		
		welcomePage = new WelcomePage();
		welcomePage = new WelcomePage();
		welcomePage.verifyWelcomePagePrivacyOption();
		signUpPage = welcomePage.verifyJoinRakutenButton(); 
		
		
	}
	
	@Test
	public void userAvailablePointsTest() throws InterruptedException {
		homePage = signUpPage.createNewAccount("droovy1", "deee1", "droovy1deee11ae@deee1.com", "Astronized1!");
		myAccountPage = homePage.goToMyAccountOption();
		Assert.assertTrue(myAccountPage.checkMyAccountPageURL(), "The URL is incorrect");
		pointsActivityPage = myAccountPage.selectPointsActivity();
		
		int expectedAvailablePoints = 0;
		int actualAvailablePoints = pointsActivityPage.getUserAvailablePoints();
		System.out.println(actualAvailablePoints);
		//Assert.assertEquals(pointsActivityPage.getUserAvailablePoints(), expectedAvailablePoints);
	}
	
	@Test
	public void userPendingPointsTest() throws InterruptedException {
		homePage = signUpPage.createNewAccount("droovy1", "deee1", "droovy1deee22ae@deee1.com", "Astronized1!");
		myAccountPage = homePage.goToMyAccountOption();
		Assert.assertTrue(myAccountPage.checkMyAccountPageURL(), "The URL is incorrect");
		pointsActivityPage = myAccountPage.selectPointsActivity();
		
		int actualPendingPoints = pointsActivityPage.getUserPendingPoints();
		int expectedPendingPoints = 0;
		Assert.assertEquals(actualPendingPoints, expectedPendingPoints);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
