package com.qa.rakuten.util;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.rakuten.testbase.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public TestUtil() throws IOException {
		super();
	}
	public void clickWithJs(WebDriver driver, WebElement element){
		js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element); 
	}
}
