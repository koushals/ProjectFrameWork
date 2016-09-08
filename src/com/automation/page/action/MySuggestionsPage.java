package com.automation.page.action;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.page.driver.BaseClass;
import com.automation.page.locators.MySuggestionEnum;

import io.appium.java_client.AppiumDriver;


public class MySuggestionsPage extends BaseClass{
	
	AppiumDriver<WebElement> driver;


	public MySuggestionsPage(AppiumDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	static By titles = By.id(MySuggestionEnum.STATIONS_TITLE_ID.toString());
	
	List<WebElement> list;
	

	public  MusicPlayerPage selectFromStations(int index){
		elements(titles).get(index).click();
		return new MusicPlayerPage(driver);
	}

	
	
	
}
