package testScripts;
import java.io.File;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;
public class BaseTest {
	
	  WebDriver Driver ;
	  ExtentHtmlReporter htmlReporter ;
	  ExtentReports extent ;
	  ExtentTest test ;
	  /**
	 * This method creates a toggle for the given test, adds all log events under it
	 * @param method is used to get the name of the test method
	 * @throws IOException
	 */
	@BeforeMethod
		public void beforeMethod(Method method) throws IOException  {
		// creates a toggle for the given test, adds all log events under it
		test=extent.createTest(method.getName());
		  Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		}

		
		
		/**
		 * 
		 * This method takes a screenshot after test method has run
		 * This method get the result of test method then shows the result within the report
		 * @param result get the status of the test case
		 */
	    
		@AfterMethod
		public void takeScreenshot(ITestResult result){
			 TakesScreenshot camera = (TakesScreenshot)Driver;
		   	    File screenshot = camera.getScreenshotAs(OutputType.FILE);
		 		 if(ITestResult.FAILURE==result.getStatus()) {
		 			 try{
		 				 
		 			    	Files.move(screenshot, new File("./screenshotsFailure/"+result.getName()+".png"));
		 			    	test.fail(result.getThrowable().getMessage(), MediaEntityBuilder
		 		                    .createScreenCaptureFromPath("./screenshotsFailure/"+result.getName()+".png").build());
		 			    }catch(IOException e){
		 			        e.printStackTrace();
		 	
		 			    }   
		 		 }
		 	        else {
		 	     	    try{
		 	     	    	Files.move(screenshot, new File("./screenshotsSuccess/"+result.getName()+".png"));
		 	     	    	test.pass("Test has passed", MediaEntityBuilder
		 		                    .createScreenCaptureFromPath("./screenshotsSuccess/"+result.getName()+".png").build());
		 	     	    }catch(IOException e){
		 	     	        e.printStackTrace();
		 	     	    }   
		 	        }
			
			/*   TakesScreenshot camera = (TakesScreenshot)Driver;
		    File screenshot = camera.getScreenshotAs(OutputType.FILE);
		    try{
		       // Files.move(screenshot, new File("D:\\test.png"));
		    	Files.move(screenshot, new File("./screenshot/test.png"));
		    }catch(IOException e){
		        e.printStackTrace();
		    }*/
		}
		
		/**
		 * This method is to call flush writes everything to the log file
		 * Close the driver 
		 */
		@AfterClass
		public void afterClass() {
		// calling flush writes everything to the log file
	        extent.flush();
			Driver.quit();
		
	}
	  /**
	 * 
	 * This method is to setup the WebDriver and launching the browser
	 * Creating the extent report
	 * @param browserName is the type of the browser instance that user want to instantiate
	 * @throws IOException
	 */
		private ChromeOptions GetChromeOptions() { 
			ChromeOptions options = new ChromeOptions();
			options.addArguments("window-size=1024,768");	
			//	options.addArguments("disable-infobars");
		//	options.setHeadless(true);
		    return options;
		}
	@BeforeClass
		@Parameters({"BrowserType"})
		public void beforeClassSetUp(@Optional("chrome")String browserName) throws IOException {
	      	// start reporters
	           htmlReporter = new ExtentHtmlReporter("extent.html");

	       // create ExtentReports and attach reporter(s)
	           extent = new ExtentReports();
	           extent.attachReporter(htmlReporter);
		
		      if (browserName.equalsIgnoreCase("chrome")) {
				 System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
				 Driver = new ChromeDriver(GetChromeOptions());
		        } else if (browserName.equalsIgnoreCase("firefox")) {
		        	System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		            Driver = new FirefoxDriver();
		        }
		    Driver.manage().window().maximize();
		    Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	         }

}
