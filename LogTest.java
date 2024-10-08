package com.keeperz.org;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class LogTest {
	WebDriver driver;

	public void setUp() throws MalformedURLException {
		// Set up desired capabilities and pass the Android app-activity and app-package
		// to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "13");
		capabilities.setCapability("deviceName", "Emulator");
		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("appPackage", "com.sysres.keeperz");
// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity", "com.sysres.keeperz.Activity.SplashActivity"); // This is Launcher activity of
																							// your app (you can get it
																							// from apk info app)
//Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the configurations
		// specified in Desired Capabilities
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}


	public void teardown() {
		// close the app
		driver.quit();
	}
}
