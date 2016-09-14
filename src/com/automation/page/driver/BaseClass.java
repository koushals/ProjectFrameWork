package com.automation.page.driver;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {
	
	protected AppiumDriver<WebElement> driver;
	private List<WebElement> list;
	
	protected String className = ""; 
	
	public BaseClass(AppiumDriver<WebElement> driver) {
		this.driver = driver;
	}
	
	protected void back() {
		driver.navigate().back();
	}

	protected void performLongPressOnCenterofElement(By locator) throws Exception
    {
      log("long press");
    	TouchAction action = new TouchAction(driver);
      action.longPress(element(locator)).release().perform();
    }
	
	protected WebElement element(By locator){
		return driver.findElement(locator);
	}
	
	protected List<WebElement> elements(By locator){
		 list = driver.findElements(locator);
		if (list.size() == 0) {
			throw new NoSuchElementException();
		}
		return list;
	}
	
	protected void SwipeUp() {
		int starty = (int) (driver.manage().window().getSize().getHeight()*0.9);
		int endy = (int) (driver.manage().window().getSize().getHeight()*0.2);
		int width = (int) (driver.manage().window().getSize().getWidth()*0.9);
		driver.swipe(width/2, starty, width/2, endy, 500);
	}
	
	protected void SwipeDown() {
		int starty = (int) (driver.manage().window().getSize().getHeight()*0.2);
		int endy = (int) (driver.manage().window().getSize().getHeight()*0.9);
		int width = (int) (driver.manage().window().getSize().getWidth()*0.9);
		driver.swipe(width/2, starty, width/2, endy, 500);
	}
	
	protected boolean elementisDisplayed(By locator) {
		try {
			boolean a =  element(locator).isDisplayed();
			return a;
		} catch (Exception e) {
			return false;
		}
	}
	

	protected void hideKeys() throws Exception {
		driver.hideKeyboard();
	}
	
	public void log(String message){
		try{
			Reporter.log(className+" - "+message);
		}catch(Exception e){}
	}
	
	protected  String getText(By locator) {
		 return element(locator).getText();
	}
	
	protected static void myAssert(boolean isTrue,StringBuffer buffer, String item){
		if(!isTrue){
			buffer.append(item+" ");
			Reporter.log(item+" is missing");
		}else
			Reporter.log(item+" Done");
	}
}
