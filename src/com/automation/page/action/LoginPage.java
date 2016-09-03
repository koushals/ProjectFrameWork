package com.automation.page.action;

import java.io.File;
import java.lang.reflect.Field;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.page.driver.BaseClass;
import com.automation.page.locators.LoginPageEnum;

import io.appium.java_client.AppiumDriver;



public class LoginPage extends BaseClass {
	
	public LoginPage(AppiumDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By loginButton = By.name(LoginPageEnum.LOGIN_NAME.toString());
	By email = By.id(LoginPageEnum.EMAIL_ID.toString());
	By password = By.id(LoginPageEnum.PASSWORD_ID.toString());
	By submitButton = By.id(LoginPageEnum.SUBMITBUTTON_ID.toString());
	By skip = By.name(LoginPageEnum.SKIP_NAME.toString());
	By ok = By.name(LoginPageEnum.OK_NAME.toString());
	
	private void enterEmail(String emailString) {
		element(email).sendKeys(emailString);
	}
	
	private void password(String passwordString) throws NoSuchFieldException {
		element(password).sendKeys(passwordString);
	
		
	}
	
	private void loginButton() {
		element(loginButton).click();
	}
	
	private void submitUser() {
		element(submitButton).click();
	}
	
	
	
	public void tapSkip() {
		element(skip).click();
		element(ok).click();
	}
	
	public void loginPage(String e, String p) throws NoSuchFieldException {
		loginButton();
		enterEmail(e);
		password(p);
		submitUser();
	}
	
	

}
