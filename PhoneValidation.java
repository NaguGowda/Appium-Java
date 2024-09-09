package com.Keeperz.org;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class PhoneValidation {
	@Test(dataProvider = "credential")
	public void loginCred(String scenario, String phoneNum) throws MalformedURLException {

		UiAutomator2Options option = new UiAutomator2Options();
		// option.setPlatformName("Android");
		option.setDeviceName("emulator-5554");
//		option.setPlatformName(MobilePlatform.ANDROID);
//		option.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
		option.setApp(
				"C:\\Users\\nagar.DESKTOP-ER55LHH\\eclipse-workspace\\KeepSplash\\src\\test\\java\\Resources\\kvtest_201.apk");
		option.setAppPackage("com.sysres.keeperz");
		option.setAppActivity("com.sysres.keeperz.Activity.SplashActivity");
		option.setAutoGrantPermissions(true);

		URL url = new URL("http://127.0.0.1:4723");
		AppiumDriver driver = new AppiumDriver(url, option);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		WebElement ctnbtn = driver.findElement(By.id("com.sysres.keeperz:id/continue_txt"));
		ctnbtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		WebElement ctnbtn1 = driver.findElement(By.id("com.sysres.keeperz:id/continue_txt"));
		ctnbtn1.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		WebElement ctnbtn2 = driver.findElement(By.id("com.sysres.keeperz:id/continue_txt"));
		ctnbtn2.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		WebElement ctnbtn3 = driver.findElement(By.id("com.sysres.keeperz:id/continue_txt"));
		ctnbtn3.click();
		WebElement ctnbtn4 = driver.findElement(By.id("com.sysres.keeperz:id/continue_txt"));
		ctnbtn4.click();

		driver.findElement(By.id("com.sysres.keeperz:id/flag_img")).click();

		driver.findElement(By.id("com.sysres.keeperz:id/india_btn")).click();

		driver.findElement(By.id("com.sysres.keeperz:id/mobile_no_edt")).sendKeys(phoneNum);

		driver.findElement(By.id("com.sysres.keeperz:id/submit_txt")).click();

		if (scenario.equals("Empty")) {
			String errormsg = driver.findElement(By.id("com.sysres.keeperz:id/body_txt")).getText();
			Assert.assertEquals(errormsg, "Enter Mobile number");
			
		} else if (scenario.equals("invalidNum")) {
			String errormsg2 = driver.findElement(By.id("com.sysres.keeperz:id/body_txt")).getText();
			Assert.assertEquals(errormsg2, "Enter Mobile number");
		} else if (scenario.equals("validNumber")) {
			WebElement Homepg = driver.findElement(By.id("com.sysres.keeperz:id/code_one_edt"));
			Assert.assertTrue(Homepg.isDisplayed());
		} else {
			String errormsg3 = driver.findElement(By.id("com.sysres.keeperz:id/body_txt")).getText();
			Assert.assertEquals(errormsg3, "Enter Mobile number");
		}

	}

	@DataProvider(name = "credential")
	public Object[][] getData() {

		return new Object[][] { { "empty", "" }, { "invalidNum", "877656" }, { "validNumber", "9098909890" } };

	}

}
