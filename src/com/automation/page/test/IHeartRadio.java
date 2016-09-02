package com.automation.page.test;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

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

	
	@BeforeTest
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
	
	
	@AfterTest
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
