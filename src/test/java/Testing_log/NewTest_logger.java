package Testing_log;

import java.sql.Driver;
import java.time.Duration;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Util.Utilities;

public class NewTest_logger extends Utilities{
  @Test
  public void verify_Homepage(){
	 test= extent.createTest("verify_Homepage").assignAuthor("lea").assignCategory("smoke").assignDevice("macc");
	//log.info("browser launched");
 // driver= new ChromeDriver(); we already call it from commons, so we don't need it here
  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  log.info("maximizing browser");
  driver.manage().window().maximize();
  driver.get("https://www.walmart.com/");
  
  
  String expectedtitle= "walmart";
  log.info("getting tilte");
  
  String actualtitle = driver.getTitle();
  log.info("title is collected");
  
  if(actualtitle.equalsIgnoreCase(expectedtitle)) {
	  log.info("title is matched");
	  test.log(Status.PASS, MarkupHelper.createLabel("verify title", ExtentColor.GREEN));
 // we used test.log to make 2 things
	  test.addScreenCaptureFromPath("succees");
  }
  
  else {
	  log.info(" title verifyed is failes", "expected= " + expectedtitle+ "but found = " +actualtitle);
      test.log(Status.FAIL, MarkupHelper.createLabel("verify title", ExtentColor.RED));
      test.addScreenCaptureFromPath(Captureforss("Allfailed"), "verify title");
      // if we want to use screenshot, we need to create another screenshot in our commons.
      test.addScreenCaptureFromPath("failed");
  }}
      
  @Test
      public void login() {
	  test= extent.createTest("login features").assignAuthor("maria").assignCategory("sanity").assignDevice("windows");
	  log.info("login execution startes");
	 // WebElement departmentbtn = driver.findElement(By.xpath("//button[text()='Departments']"));
	 // departmentbtn.click();
  }
  
  @Test
  public void f() {
	  log.info("test f");
  }
	  
 

	
} 

