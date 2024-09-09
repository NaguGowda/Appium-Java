package com.Keeperz.org;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.remote.AutomationName;
//import io.appium.java_client.remote.MobilePlatform;

public class AppLaunch {
	private static final long Null = 0;
	AppiumDriver driver;
	String WlcomeText = "WELCOME TO KEEPERZ";

	@Test
	public void configApp() throws MalformedURLException {
		UiAutomator2Options option = new UiAutomator2Options();
		// option.setPlatformName("Android");
//		option.setDeviceName("emulator-5554");
		option.setDeviceName("25ea7c96");
//		option.setPlatformName(MobilePlatform.ANDROID);
//		option.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
		option.setApp(
				"C:\\Users\\nagar.DESKTOP-ER55LHH\\eclipse-workspace\\KeepSplash\\src\\test\\java\\Resources\\kv_test_208.apk");
		option.setAppPackage("com.sysres.keeperz");
		option.setAppActivity("com.sysres.keeperz.Activity.SplashActivity");
		option.setAutoGrantPermissions(true);
		option.setCapability("autoAcceptAlerts", true);

		URL url = new URL("http://127.0.0.1:4723");
		AppiumDriver driver = new AppiumDriver(url, option);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
//First
		String WelText1 = driver.findElement(By.id("com.sysres.keeperz:id/welcome_txt")).getText();
		if (WelText1.equals(WlcomeText)) {
			System.out.println("True :" + WelText1);
			String s1 = driver.findElement(By.id("com.sysres.keeperz:id/description_txt")).getText();
			System.out.println(s1);
		}
		WebElement ctnbtn = driver.findElement(By.id("com.sysres.keeperz:id/continue_txt"));
		ctnbtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
//Second
		String WelText2 = driver.findElement(By.id("com.sysres.keeperz:id/welcome_txt")).getText();
		if (WelText1.equals(WlcomeText)) {
			System.out.println("True :" + WelText2);
			System.out.println(
					"Explore new pleasant dining experiences based on genuine recommendation from your fellow keeperz\n");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));

		WebElement ctnbtn1 = driver.findElement(By.id("com.sysres.keeperz:id/continue_txt"));
		ctnbtn1.click();
		System.out.println("True :Enjoy exclusive discount offers at most of our partner restaurants");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		WebElement ctnbtn2 = driver.findElement(By.id("com.sysres.keeperz:id/continue_txt"));
		ctnbtn2.click();
		System.out.println(
				"True :Inspire your fellow keeperz and contribute to your community by sharing authentic experience and making insightful recommendations\n");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		WebElement ctnbtn3 = driver.findElement(By.id("com.sysres.keeperz:id/continue_txt"));
		ctnbtn3.click();
		System.out.println("Earn unmatched cashback rewards throughout almost every activity you do in keeperz app\n");
		WebElement ctnbtn4 = driver.findElement(By.id("com.sysres.keeperz:id/continue_txt"));
		ctnbtn4.click();

		driver.findElement(By.id("com.sysres.keeperz:id/flag_img")).click();

		driver.findElement(By.id("com.sysres.keeperz:id/india_btn")).click();

		String mobileNumber = generateRandomMobileNumber(10);

		if (mobileNumber != null) {
			WebElement mobNumber = driver.findElement(By.id("com.sysres.keeperz:id/mobile_no_edt"));
			mobNumber.sendKeys(mobileNumber);
			
		}

		WebElement Submitbtb = driver.findElement(By.id("com.sysres.keeperz:id/submit_txt"));
		Submitbtb.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));

		// Generating the OTP using random code
		int randomNum = generateRandInt();
		int randomNum2 = generateRandInt();

		if (randomNum != Null) {
			WebElement code1 = driver.findElement(By.id("com.sysres.keeperz:id/code_one_edt"));
			code1.sendKeys(String.valueOf(randomNum));
		}

		if (randomNum2 != Null) {
			WebElement code2 = driver.findElement(By.id("com.sysres.keeperz:id/code_two_edt"));
			code2.sendKeys(String.valueOf(randomNum2));
		}

		int randomNum3 = generateRandInteger();
		int randomNum4 = generateRandInteger();

		if (randomNum3 != Null) {
			WebElement code3 = driver.findElement(By.id("com.sysres.keeperz:id/code_three_edt"));
			code3.sendKeys(String.valueOf(randomNum3));
		}

		if (randomNum4 != Null) {
			WebElement code3 = driver.findElement(By.id("com.sysres.keeperz:id/code_four_edt"));
			code3.sendKeys(String.valueOf(randomNum4));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9000));

		String randomString = generateRandomString(5);

		WebElement inputTextBox = driver.findElement(By.id("com.sysres.keeperz:id/username_edt"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));

		inputTextBox.sendKeys(randomString);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));

		String randomString1 = generateMixedInput(5);

		WebElement inputTextBox2 = driver.findElement(By.id("com.sysres.keeperz:id/lastname_edt"));

		inputTextBox2.sendKeys(randomString1);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));

		driver.findElement(By.id("com.sysres.keeperz:id/email_edt")).sendKeys("Vikki123@gmail.com");

		String refecode = driver.findElement(By.id("com.sysres.keeperz:id/referral_edt")).getText();

		System.out.println(refecode);

		driver.findElement(By.id("com.sysres.keeperz:id/submit_txt")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));

		driver.findElement(By.id("com.sysres.keeperz:id/ok_lo")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));

//		Wait wait = new FluentWait(driver)
//		           .withTimeout(Duration.ofSeconds(8))
//		           .pollingEvery(Duration.ofSeconds(10))
//		           .ignoring(NoSuchElementException.class)
//		           .ignoring(TimeoutException.class);
//		   wait.until(ExpectedConditions.visibilityOfElementLocated
//		   (By.id("com.android.permissioncontroller:id/permission_allow_button")));
//		
//		
//		By elementLocator = By.id("com.android.permissioncontroller:id/permission_allow_button");
//		wait1.until(ExpectedConditions.elementToBeClickable(elementLocator));
//
//
//		WebElement clickableElement = driver.findElement(elementLocator);
//		clickableElement.click();

//		WebElement timewait = wait1.until(ExpectedConditions
//				.visibilityOfElementLocated(By.id("com.android.permissioncontroller:id/permission_allow_button")));
//		timewait.click();

		// driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
//
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9000));
//
//		driver.findElement(By.id("com.sysres.keeperz:id/done_txt")).click();
//
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.sysres.keeperz:id/home")));
//
//		driver.findElement(By.id("com.sysres.keeperz:id/user_name_txt"));

	}

	private static int generateRandInt() {
		Random randomNum = new Random();
		return randomNum.nextInt(9);
	}

	private static int generateRandInteger() {
		Random randomNum = new Random();
		return randomNum.nextInt(9);
	}

	public static String generateRandomString(int length) {
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuilder randomString = new StringBuilder();

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characters.length());
			randomString.append(characters.charAt(randomIndex));
		}

		return randomString.toString();
	}

	public static String generateMixedInput(int length) {
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		Random random = new Random();
		StringBuilder mixedInput = new StringBuilder();

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characters.length());
			mixedInput.append(characters.charAt(randomIndex));
		}

		return mixedInput.toString();
	}

	public static String generateRandomMobileNumber(int length) {
		if (length != 10) {
			throw new IllegalArgumentException("Mobile number length must be 10 digits");
		}

		Random random = new Random();
		StringBuilder mobileNumber = new StringBuilder();

		for (int i = 0; i < length; i++) {
			int digit = random.nextInt(10);
			mobileNumber.append(digit);
		}

		return mobileNumber.toString();
	}

	@AfterTest
	public void tearDown() {

		if (driver != null)
			driver.close();

	}
}