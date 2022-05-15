package com.qa.rakuten.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.rakuten.testbase.TestBase;

public class SignUpPage extends TestBase{
	
	
	
	@FindBy(xpath="//div[@class='s t wc hc' and text()='Create a new account']")
	WebElement signUpPageCreateNewAccountLabel;
	
	@FindBy(xpath="//input[@aria-label='First name']")
	WebElement signUpPageFirstName;
	
	@FindBy(xpath="//input[@aria-label='Last name']")
	WebElement signUpPageLastName;
	
	@FindBy(xpath="//input[@aria-label='Email']")
	WebElement signUpPageEmail;
	
	@FindBy(xpath="//input[@aria-label='Password']")
	WebElement signUpPagePassword;
	
	@FindBy(xpath="//div[@role='checkbox']/..//div[text()='Show password']")
	WebElement signUpPageShowPasswordCheckBox;
	
	@FindBy(xpath="//div[@role='checkbox']/..//div[contains(text(),'Subscribe to Rakuten UK')")
	WebElement signUpPageSubscribeCheckBox;
	
	@FindBy(xpath="//div[@role='checkbox']/..//div[contains(text(),'You acknowledge to have')]")
	WebElement signUpPagePrivacyPolicyCheckBox;
	
	@FindBy(xpath="//div[@role='button']/div[contains(text(),'Create a new account')]")
	WebElement signUpPageCreateAccountButton;
	
	@FindBy(xpath="//div[@role='button']/div[contains(text(),'Complete registration')]")
	WebElement signUpPageCompleteRegistrationButton;
	
	
	
	
	public SignUpPage() throws InterruptedException, IOException {
		PageFactory.initElements(driver, this);		
	}
	
	public HomePage createNewAccount(String firstNameText, String lastNameText, String emailIdText, String passwordText) {
		signUpPageFirstName.click();
		signUpPageFirstName.sendKeys(firstNameText);
		signUpPageLastName.sendKeys(lastNameText);
		signUpPageEmail.sendKeys(emailIdText);
		signUpPagePassword.sendKeys(passwordText);
		
		if(!signUpPagePrivacyPolicyCheckBox.isSelected()) {
			signUpPagePrivacyPolicyCheckBox.click();
		}
		
		signUpPageCreateAccountButton.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='button']/div[contains(text(),'Complete registration')]")));
		signUpPageCompleteRegistrationButton.click();
		
		return new HomePage();
	}
	
	
		

}
