package com.automation.page.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.page.driver.BaseClass;
import com.automation.page.locators.MusicPlayerEnum;

import io.appium.java_client.AppiumDriver;


public class MusicPlayerPage extends BaseClass{
	
	 By time = By.id(MusicPlayerEnum.TIMEPLAYED_ID.toString());
	 By like = By.id(MusicPlayerEnum.LIKE_ID.toString());
	 By dislike = By.id(MusicPlayerEnum.DISLIKE_ID.toString());
	 By love = By.id(MusicPlayerEnum.LOVE_ID.toString());
	 By next = By.id(MusicPlayerEnum.NEXT_ID.toString());
	 
	 
	public MusicPlayerPage(AppiumDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public  String getTime() {
		return getText(time);
	}
	
	public void likeAlbum() {
		element(like).click();
	}
	public  boolean likeisDisplayed() {
		return elementisDisplayed(like);
	}
	
	public  boolean dislikeisDisplayed() {
		return elementisDisplayed(dislike);
	}
	
	public  boolean loveisDisplayed() {
		return elementisDisplayed(love);
	}
	
	public  boolean nextisDisplayed() {
		return elementisDisplayed(next);
	}

}
