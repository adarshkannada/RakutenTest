package com.qa.rakuten.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.rakuten.testbase.TestBase;

public class PointsActivityPage extends TestBase{
	
	@FindBy(xpath="//span[@class='tst-pinn sc-iQtOjA dnxNZr']/span[@data-qa-id='rewards-banner-points-amount-left-side']")
	WebElement pointsActivityAvailablePoints;
	
	@FindBy(xpath="//span[@class='tst-pinn sc-iQtOjA dnxNZr']/span[@data-qa-id='rewards-banner-points-amount-right-side']")
	WebElement pointsActivityPendingPoints; 
	
	public PointsActivityPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public int getUserAvailablePoints() throws InterruptedException {
		wait.until(ExpectedConditions.textToBePresentInElement(pointsActivityAvailablePoints, "0"));
		String availablePointsRead = pointsActivityAvailablePoints.getText();
		int availablePointsConverted = Integer.parseInt(availablePointsRead);
		return availablePointsConverted;
	}
	
	public int getUserPendingPoints() throws InterruptedException {
		wait.until(ExpectedConditions.textToBe(By.xpath("//span[@class='tst-pinn sc-iQtOjA dnxNZr']/span[@data-qa-id='rewards-banner-points-amount-right-side']"), "0"));
		String pendingPointsRead = pointsActivityPendingPoints.getText();
		int pendingPointsConverted = Integer.parseInt(pendingPointsRead);
		return pendingPointsConverted;
		
		
	}
	

}
