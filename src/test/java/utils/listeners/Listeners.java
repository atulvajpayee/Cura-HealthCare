package utils.listeners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import Config.StartDriver;
import Config.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

import utils.extent.ExtentInstance;

public class Listeners implements ITestListener {

	public static ExtentInstance extentInstance;
	public static ExtentReports listReport = ExtentInstance.getReport();
	public static StartDriver s = new StartDriver();
	WebDriver driver = s.getDriver();
	private static int passCount = 0;
	private static int failCount = 0;
	private static int skipCount = 0;

	public void onTestStart(ITestResult result) {

		String modulename = getTestMethodGroup(result);
		System.out.println("Test Start " + result.getMethod().getMethodName());

		/*
		 * The following code will update the test ITestResult with the test id from the
		 * test parameters This is to be used if the test case is making use of a data
		 * provider ; passing the test ID wll enable the tester to combine multiple test
		 * cases in a single test method.
		 */
		Object[] testParams = result.getParameters();
		for (Object param : testParams) {
			if (param.getClass().equals(String.class)
					&& param.toString().trim().toLowerCase(Locale.ENGLISH).startsWith("tcm")) {
				result.getMethod().setDescription(param.toString());
			}
		}

		List<Object> paramList = new ArrayList<>();
		if (testParams.length != 0) {
			paramList = Arrays.asList(testParams);
		}
		String methodName = "";
		try {
			if (result.getTestContext().getAttribute("testName").toString() != "") {
				methodName = result.getTestContext().getAttribute("testName").toString();
			} else {
				methodName = result.getMethod().getMethodName();
			}
		} catch (Exception e) {
			methodName = result.getMethod().getMethodName();
		}
		methodName = paramList.size() == 0 ? methodName : methodName + paramList;
		ExtentInstance.addTest(methodName, modulename, result);
		ExtentInstance.addInfo("Test has begun");
		listReport.flush();
	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("Test " + result.getName() + " has succeeded");
		String description = "";
		if (result.getMethod().getDescription() == null) {
			description = result.getMethod().getMethodName() + " has Passed";
		}

		ExtentInstance.addPass(description + " passed");
		passCount++;

		listReport.flush();
		ExtentInstance.test = null;

	}

	public void onTestFailure(ITestResult result) {
		failCount++;
		System.out.println("Test " + result.getName() + " has failed");
		String description = "";
		if (result.getMethod().getDescription() == null) {
			description = result.getMethod().getMethodName() + " has Failed";
		}
		ExtentInstance.addFail(result.getThrowable().getMessage());
		ExtentInstance.addFail(description);
		if (driver != null) {
			ExtentInstance.addScreenshotB64(Utility.captureScreenshot(driver));

		}
		listReport.flush();
		ExtentInstance.test = null;

	}

	public void onTestSkipped(ITestResult result) {
		skipCount++;
		System.out.println("On test skip");
		String description = "";
		if (result.getMethod().getDescription() == null) {
			description = result.getMethod().getMethodName() + " has Skipped";
		}
		ExtentInstance.addSkip("The test " + result.getMethod().getMethodName() + " was skipped.");
		if (driver != null) {
			ExtentInstance.addScreenshotB64(Utility.captureScreenshot(driver));
			ExtentInstance.addScreenshot(Utility.captureScreenshot(driver));
		}
		listReport.flush();
		ExtentInstance.test = null;

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("On test fail");
		listReport.flush();
		ExtentInstance.test = null;
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		iTestContext.getCurrentXmlTest().getSuite().getName();
		System.out.println("Test on Start");
		listReport.flush();
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println("Test Finish");
		// try {
//	      csvreport.close();
//	    }catch (IOException e){
//	      System.out.println("CSV ERROR");
//	    }
		listReport.flush();
	}

	private static String getTestMethodGroup(ITestResult result) {
		String modulename = "";
		String[] testGroups = result.getMethod().getGroups();
		for (String gp : testGroups) {
			if (gp.contains("Module")) {
				modulename = gp;
			}
		}
		return modulename;
	}

	public static int getpassCount() {
		return passCount;
	}

	public static int getfailCount() {
		return failCount;
	}

	public static int getskipCount() {
		return skipCount;
	}

}
