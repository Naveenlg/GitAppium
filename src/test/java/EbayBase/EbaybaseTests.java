package EbayBase;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class EbaybaseTests {
	
	public static AppiumDriverLocalService appiumService;
	public static AndroidDriver<WebElement> driver;
	public static String appiumServiceUrl;
	public static ExtentReports extentreport;
	public static ExtentTest extenttest;
	public static String sdkPath= "C:/Users/Win10/AppData/Local/Android/Sdk/emulator/";
	public static String emulatorPath= sdkPath +"emulator";
	public static String nameOfAVD="NaveenEmulator";
	
	
	@BeforeTest()
	public static void start_server() {
		
		appiumService = AppiumDriverLocalService.buildDefaultService();
		appiumService.start();
        appiumServiceUrl = appiumService.getUrl().toString();
        System.out.println("Appium Service Address : - "+ appiumServiceUrl);
		
	}
	
	@Test(priority=1)
	public static void launchEmulator(String nameOfAVD) {
		 System.out.println("Starting emulator for '" + nameOfAVD + "' ...");
		 String[] aCommand = new String[] { emulatorPath, "-avd", nameOfAVD };
		 try {
		  Process process = new ProcessBuilder(aCommand).start();
		  process.waitFor(300, TimeUnit.SECONDS);
		  System.out.println("Emulator launched successfully!");
		 } catch (Exception e) {
		  e.printStackTrace();
		 }
		}

	@Test(priority=2)
	public static void SetUPInit() throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	//device details
	
	capabilities.setCapability("deviceName", "NaveenEmulator");
	
	capabilities.setCapability("platformName", "Android");
	
	capabilities.setCapability("platformVersion", "11");
	
	capabilities.setCapability("automationName", "UiAutomator2");

	
	//app details
		
     //Launch Amazon App
	
   // capabilities.setCapability("app","D:/Selenium_Programs_Java/EbayTestcases/src/test/resources/Amazon_shopping.apk");
    
	capabilities.setCapability("appPackage","com.amazon.mShop.android.shopping");
	
	capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
	
	 driver = new AndroidDriver<WebElement>(new URL(appiumServiceUrl),capabilities);

	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
	 //Thread.sleep(20000);

	}
	
	@Test(priority=3)
	public static void ExtentReports() {
		
		Date date = new Date();
		
		SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD-hh-mm-ss");
		
		String Report =df.format(date);
		
		extentreport = new ExtentReports(System.getProperty("user.dir")+ Report+ "\\ExtentReportResults.html",false);
		
	}
	@Test(priority=4)
	public  static void ExplicitWait(WebElement ele, long t1) {
		WebDriverWait wait = new WebDriverWait(driver,t1);
		wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
	}
	
	@Test(priority=5)
	public static String snapshot(String TC_ID, String Order) throws IOException {
		
		Date date=new Date();
		
		SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD-hh-mm-ss");
		
		File file = new File(df.format(date)+".png");
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		
		File screenshotAs= screenshot.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshotAs, new File("D:/Selenium_Programs_Java/EbayTestcases/Screenshots" + "Screenshots"
		+ TC_ID + Order + file));
		
		String path = "D:/Selenium_Programs_Java/EbayTestcases/Screenshots" 
					+ TC_ID + Order + file;
       return path;
	}
    
	@AfterTest()
	public static void Stop_Server() {
		
		System.out.println("Stop driver");
		driver.quit();
		System.out.println("Stop appium service");
		appiumService.stop();
		
		extentreport.endTest(extenttest);
		extentreport.flush();
		
	}

}
