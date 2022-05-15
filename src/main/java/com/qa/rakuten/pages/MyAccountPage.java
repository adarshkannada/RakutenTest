package com.qa.rakuten.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.rakuten.testbase.TestBase;

public class MyAccountPage extends TestBase{
	
	
	
	
	@FindBy(xpath = "//a[@class='sc-gbOuXE EVTKX'and@href='/points-club']")
	WebElement myActivityLink;
	
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean checkMyAccountPageURL() {
		String currentUrl = driver.getCurrentUrl();
		boolean urlHasTheWord = currentUrl.contains("personal-information");
		if(!urlHasTheWord) {
			//System.out.println("The URL is not correct");
			return false;
		} else {
			//System.out.println("The URL is correct");
			return true;
		}
	}
	
	public PointsActivityPage selectPointsActivity() {
		myActivityLink.click();		
		return new PointsActivityPage();
	}
}
