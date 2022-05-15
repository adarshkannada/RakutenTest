package com.qa.rakuten.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.rakuten.testbase.TestBase;
import com.qa.rakuten.util.TestUtil;

public class HomePage extends TestBase{


	@FindBy(id = "emarsys-consent-cancel")
	WebElement homePageRejectNotificationButton;

	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open']/..//div[@class='oec-modal_modal__close_click__21XYP']")
	WebElement homePageCloseNotificationIcon;

	@FindBy(xpath = "//*[contains(text(),'droovy1')]")
	WebElement homePageUserNameText;
	
	@FindBy(css="a.profile-dropdown_profileIcon__Drxrp")
	WebElement homePageUserProfileIcon;
	
	@FindBy(xpath="(//*[contains(text(),'Welcome')])[1]")
	WebElement homePageWelcomeText;


	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public static Actions actions;
	WelcomePage welcomePage;
	
	public void homePageRejectNotification() throws IOException {
		TestUtil testUtil = new TestUtil();
		testUtil.clickWithJs(driver, homePageCloseNotificationIcon);
	}

	public String getUserName() {
		if(!driver.findElements(By.xpath("//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open']/..//div[@class='oec-modal_modal__close_click__21XYP']")).isEmpty()) {
			homePageCloseNotificationIcon.click();

		}
		return homePageUserNameText.getText();
	}
	
	public MyAccountPage goToMyAccountOption() {
		wait.until(ExpectedConditions.textToBePresentInElement(homePageWelcomeText, "Welcome"));
		actions = new Actions(driver);
		actions.moveToElement(homePageUserProfileIcon).build().perform(); //hovering over the profile icon
		
		WebElement homePageMenuMyAccount = driver.findElement(By.xpath(("//div[@class='profile-dropdown_button__UNP_3'and@data-qa-id='profile-dropdown-link-row1-0']")));
		homePageMenuMyAccount.click();
		return new MyAccountPage();
	}


}
