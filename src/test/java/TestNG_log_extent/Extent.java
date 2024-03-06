package TestNG_log_extent;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sun.tools.sjavac.Log;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class Extent {
	 ExtentReports extent = new ExtentReports();
	  ExtentSparkReporter spark = new ExtentSparkReporter("Results/" +System.currentTimeMillis()+"kathia.html");
	  
	  //ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
	  // we have all our report in target, it's better to put everything on Results folder, 
	  // we can replace target with Results, and add a name instead of spark,
	  //we can add System.currentTimeMillis() to get the report whenever we need it

	  
	
  @Test
  public void navigate_to_homepage() {
	  ExtentTest test= extent.createTest("launched browser").assignAuthor("kathia").assignCategory("smoke").assignDevice("windows");
	  	  Log.info("heading to homepage");
       // go to url
	  test.info("user succesfully land on home page");
      //validate page title
	  test.info("page title pass");
	  
  
  
  
  }
  
  @Test
  public void test1() {
	  ExtentTest test= extent.createTest("login functionnality").assignAuthor("urmin").assignCategory("regression").assignDevice("mac");
	  //go to login page(locate element, go over there and click)
	  //click on logging field and type email and password
	  //click on login
	  //wait for alert
	  // accept alert
	  //verify the login succesfully
	  test.pass("user succesfully logged in");
	  
  }
  @Test
  public void test2() {
	  ExtentTest test= extent.createTest("registration functionnality").assignAuthor("lina").assignCategory("smoke").assignDevice("windows");
	  //go to login page(locate element, go over there and click)
	  //click on logging field and type email and password
	  //click on login
	  //wait for alert
	  // accept alert
	  //verify the login succesfully
	  test.fail("registration is failed");
	  
  }
  
  @BeforeTest
  public void beforeTest() {
	 // ExtentReports extent = new ExtentReports();
	//  ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
// we can put them at the top to make them global since we're gonna use them again
	 	
	  
	  
	  extent.attachReporter(spark);// we need to declare this one as the first thing before test

  }

  @AfterTest
  public void afterTest() {
	  extent.flush();
  }

}
