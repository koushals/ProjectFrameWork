package com.automation.page.test;

import java.io.File;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
	DesiredCapabilities capablities =new DesiredCapabilities();
	File file;
	PropertyUtil p;
	Properties pt;
	private final static String DEVICENAME =  "deviceName";	
	private final static String PLATFORMVERSION =  "platformversion";
	private final static String APP =  "app";
	private final static String PLATFORMNAME =  "platformName";
	private final static String APKFILENAME =  "apkFileName";
	private final static String URL =  "url";


	
	@BeforeMethod
	public void	createTheInstance() throws Exception{
		DesiredCapabilities capablities =new DesiredCapabilities();
		p = new PropertyUtil(fileName);
		pt = p.getPropertiesFromFile();
		File f = new File(System.getProperty("user.dir")+"\\app\\"+pt.getProperty(APKFILENAME));
		capablities.setCapability(DEVICENAME,pt.getProperty(DEVICENAME));
		capablities.setCapability(PLATFORMNAME, pt.getProperty(PLATFORMNAME));
		capablities.setCapability(PLATFORMVERSION, pt.get(PLATFORMVERSION));
		if (pt.getProperty(PLATFORMNAME).equals("ios")) {
			driver = new IOSDriver<WebElement>(new URL(p.getPropertiesFromFile().getProperty(URL)), capablities);
		}else {
			capablities.setCapability(APP, f.getAbsolutePath());
			driver = new AndroidDriver<>(new URL(pt.getProperty(URL)), capablities);
		}
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void playSong() throws Exception{
		String email = pt.getProperty("email");
		String password = pt.getProperty("password");
		LoginPage lp = new LoginPage(driver);
		lp.tapSkip();
		HomePage h = lp.loginPage(email, password);
		MySuggestionsPage m =h.tapOnMySuggestion(); 
		MusicPlayerPage mp = m.selectFromStations(0);
	}
	
	@Test
	public void likeAlbum() throws Exception{
		String email = pt.getProperty("email");
		String password = pt.getProperty("password");
		LoginPage lp = new LoginPage(driver);
		lp.tapSkip();
		HomePage h = lp.loginPage(email, password);
		MySuggestionsPage m =h.tapOnMySuggestion(); 
		MusicPlayerPage mp = m.selectFromStations(0);
		mp.likeAlbum();
	}
	
	
	@AfterMethod
	public void tearDown() throws Exception{
		if (driver != null) {
			System.out.println("tearDown is called ...");
			Thread.sleep(2000);
			driver.navigate().back();
			driver.navigate().back();
			driver.quit();
		}
	}
}
