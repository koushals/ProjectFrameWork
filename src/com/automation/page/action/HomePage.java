package com.automation.page.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.page.driver.BaseClass;
import com.automation.page.locators.HomePageEnum;

import io.appium.java_client.AppiumDriver;


public class HomePage extends BaseClass{
	
	
	public HomePage(AppiumDriver<WebElement> driver) {
		super(driver);
		className = this.getClass().getName();
	}

	 By nofitication = By.id(HomePageEnum.SUGGESTION_ID.toString());
	 By dismiss = By.id(HomePageEnum.DISMISS_ID.toString());
	 By mySuggestionTab = By.name(HomePageEnum.MY_STATIONS_NAME.toString());
	
	public   void dismissNotifications() {
		try {
			element(nofitication);
			element(dismiss).click();			
		} catch (Exception e) {
		}
	}
	
	public MySuggestionsPage tapOnMySuggestion() {
		element(mySuggestionTab).click();
		System.out.println(className);
		return new MySuggestionsPage(driver);
	}
	

}
