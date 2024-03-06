package Util;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.devtools.v114.browser.Browser;
import org.testng.annotations.AfterClass;

public class Utilities extends Commons{
  @Test
  public void f() {
  }
  //we need to copy before and after test method here , because we need to use is all the wat top, and all the way buttom
  @BeforeTest
  public void beforeTest() {
	 // extent.attachReporter(spark);// we need to declare this one as the first thing
	  //we just need to call the method since we have the spark reporter on it.
	  configreport();

  }

  @AfterTest
  public void afterTest() {
	  extent.flush();
  }
  

  
  @Parameters({"browser","website"})

  @BeforeClass
  public void beforeClass(String browsername, String urlname) throws InterruptedException {
  browser(browsername,urlname);
  
  }

  @AfterClass
  public void afterClass() {
	  log.info("window closed");
	  teardown();

  }

}
