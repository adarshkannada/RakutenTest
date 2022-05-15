package com.qa.rakuten.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.rakuten.testbase.TestBase;

public class PointsActivityPage extends TestBase{
	
	@FindBy(xpath="//span[@class='tst-pinn sc-iQtOjA dnxNZr']/span[@data-qa-id='rewards-banner-points-amount-left-side']")
	WebElement pointsActivityAvailablePoints;
	
	@FindBy(xpath="//span[@class='tst-pinn sc-iQtOjA dnxNZr']/span[@data-qa-id='rewards-banner-points-amount-right-side']")
	WebElement pointsActivityPendingPoints; 
	
	public PointsActivityPage() {
		PageFactory.initElements(driver, this);
	}
	
	public int getUserAvailablePoints() {
		String availablePointsRead = pointsActivityAvailablePoints.getText();
		int availablePointsConverted = Integer.parseInt(availablePointsRead);
		return availablePointsConverted;
	}
	
	public int getUserPendingPoints() {
		String pendingPointsRead = pointsActivityPendingPoints.getText();
		int pendingPointsConverted = Integer.parseInt(pendingPointsRead);
		return pendingPointsConverted;
	}
	

}
