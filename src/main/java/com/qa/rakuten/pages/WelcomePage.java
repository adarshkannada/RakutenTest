package com.qa.rakuten.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.rakuten.testbase.TestBase;

public class WelcomePage extends TestBase{

	@FindBy(css="a.profile-dropdown_profileIcon__Drxrp")
	WebElement welcomePageUserProfileIcon;

	@FindBy(xpath = "//span[text()='Join Rakuten']")
	WebElement welcomePageJoinRakutenButton;
	
	@FindBy(xpath = "//span[contains(text(),'I Agree')]")
	WebElement welcomePagePrivacyAcceptButton;

	
	public static Actions actions;
	


	public WelcomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyWelcomePagePrivacyOption() {
		if(welcomePagePrivacyAcceptButton.isEnabled()) {
			welcomePagePrivacyAcceptButton.click();
			return true;
		}
		return false;
		
		
	}

	public SignUpPage verifyJoinRakutenButton() throws InterruptedException, IOException {
		
		actions = new Actions(driver);
		actions.moveToElement(welcomePageUserProfileIcon).build().perform(); //hovering over the profile icon
		Thread.sleep(1000);
		
		WebElement welcomePageJoinRakutenButton = driver.findElement(By.xpath("//span[text()='Join Rakuten']")); //identifying the rakuten button
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Join Rakuten']"))); // waiting for rakuten button to be visible
		//actions.moveToElement(welcomePageJoinRakutenButton).click().perform(); //moving mouse to button and click using actions
		//return welcomePageJoinRakutenButton.isEnabled();
		welcomePageJoinRakutenButton.click(); //click on join button
		Thread.sleep(3000);
		return new SignUpPage();
		
		

	}
}
