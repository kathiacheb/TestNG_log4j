package Listenerpack;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import Util.Utilities;

public class Listener extends Utilities implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
	this.driver= ((Utilities)result.getInstance()).driver;
	  
	screenshot("Allsucceed");
	System.out.println("screenshot is taking succesfully");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		this.driver= ((Utilities)result.getInstance()).driver;

		screenshot("Allfailed");
		System.out.println("test is failed");
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		this.driver= ((Utilities)result.getInstance()).driver;
		System.out.println("test is skipped");

			}
 

	
	
}
