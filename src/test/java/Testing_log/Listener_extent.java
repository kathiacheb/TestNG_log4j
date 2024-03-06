package Testing_log;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Util.Utilities;

public class Listener_extent extends Utilities implements ITestListener{

	
	@Override
	public void onStart(ITestContext context) {
	//beforetest
		// if we didn't have configreport in commons, we need to call this : extent.attachReporter(spark);
		configreport();
		log.info(" on start listenet, extent configuration");
		
	}

	@Override
	public void onFinish(ITestContext context) {
	//aftertest
		
		extent.flush(); 
		log.info("on finish listener, extent configuration done");	
	}

	@Override
	public void onTestStart(ITestResult result) {
	log.info("context starts, now execution:" + result.getName());	
	// get.name means the name of the test method
	}
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test= extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("name of the passed method:" +result.getName(), ExtentColor.GREEN));
		
		this.driver= ((Utilities)result.getInstance()).driver;
	
		test.addScreenCaptureFromPath(Captureforss("Allsucceed"));
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test= extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("named of the failed method:" +result.getName(), ExtentColor.RED));
		this.driver= ((Utilities)result.getInstance()).driver;
		test.addScreenCaptureFromPath(Captureforss("Allfailed"));
		
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("named of the skiped method:" +result.getName(), ExtentColor.YELLOW));
		this.driver= ((Utilities)result.getInstance()).driver;
		test.addScreenCaptureFromPath(Captureforss("Allskipped"));
		
		}

	

	
	
	
}
