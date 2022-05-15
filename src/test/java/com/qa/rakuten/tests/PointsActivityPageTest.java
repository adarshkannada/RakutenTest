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
	public void userAvailablePointsTest() {
		homePage = signUpPage.createNewAccount("droovy1", "deee1", "droovy1deee89m@deee1.com", "Astronized1!");
		myAccountPage = homePage.goToMyAccountOption();
		pointsActivityPage = myAccountPage.selectPointsActivity();
		
		int expectedAvailablePoints = 0;
		Assert.assertEquals(pointsActivityPage.getUserAvailablePoints(), expectedAvailablePoints);
	}
	
	@Test
	public void userPendingPointsTest() {
		homePage = signUpPage.createNewAccount("droovy1", "deee1", "droovy1deee89k@deee1.com", "Astronized1!");
		myAccountPage = homePage.goToMyAccountOption();
		pointsActivityPage = myAccountPage.selectPointsActivity();
		
		int actualPendingPoints = pointsActivityPage.getUserPendingPoints();
		int expectedPendingPoints = 500;
		Assert.assertEquals(actualPendingPoints, expectedPendingPoints);
	}
    
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
