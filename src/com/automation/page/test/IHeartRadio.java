package com.automation.page.test;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.page.action.HomePage;
import com.automation.page.action.LoginPage;
import com.automation.page.action.MusicPlayerPage;
import com.automation.page.action.MySuggestionsPage;
import com.automation.utils.PropertyUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class IHeartRadio {
	
	AppiumDriver<WebElement> driver;
	private final  String fileName= "iHeartRadio.properties";
	DesiredCapabilities capablities;
	File file;
	PropertyUtil p = new PropertyUtil(fileName);
	private final  String DEVICENAME =  "deviceName";	
	private final  String PLATFORMVERSION =  "platformversion";
	private final  String APPPACKAGE =  "appPackage";
	private final  String APP =  "app";
	private final  String PLATFORMNAME =  "platformName";
	private final  String APPACTIVITY =  "appActivity";
	private final  String APKFILENAME =  "apkFileName";
	private final  String URL =  "url";
	

	
	@BeforeMethod
	public void	createTheInstance() throws Exception{
		capablities.setCapability(DEVICENAME,p.getPropertiesFromFile().getProperty(DEVICENAME));
		capablities.setCapability(PLATFORMNAME, p.getPropertiesFromFile().getProperty(PLATFORMNAME));
		capablities.setCapability(APPPACKAGE, p.getPropertiesFromFile().getProperty(APPPACKAGE));
		if (p.getPropertiesFromFile().getProperty(PLATFORMNAME).equals("ios")) {
			driver = new IOSDriver<WebElement>(new URL(p.getPropertiesFromFile().getProperty(URL)), capablities);
		}else {
			capablities.setCapability(APPACTIVITY, p.getPropertiesFromFile().getProperty(APPACTIVITY));
			driver = new AndroidDriver<WebElement>(new URL(p.getPropertiesFromFile().getProperty(URL)), capablities);
		}			
	}
	
	
	@Test
	public void playSong() throws Exception{
		String email = p.getPropertiesFromParameter("email");
		String password = p.getPropertiesFromParameter("password");
		LoginPage lp = new LoginPage(driver);
		lp.tapSkip();
		HomePage h = lp.loginPage(email, password);
		MySuggestionsPage m =h.tapOnMySuggestion();
		MusicPlayerPage mp = m.selectFromStations(0);
		
	}
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		if (driver != null) {
			System.out.println("tearDown is called ...");
			Thread.sleep(2000);
			driver.navigate().back();
			driver.navigate().back();
			driver.quit();
		}
	}
	

}
