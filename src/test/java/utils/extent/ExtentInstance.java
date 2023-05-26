package utils.extent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Config.ConfigManager;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.codec.binary.Base64;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;


public class ExtentInstance {

	// public static WebDriver driver;

	public static ExtentHtmlReporter htmlReport; // look and feel of the report
	public static ExtentReports extentReport;
	public static ExtentTest test;
	public static ExtentTest classTest;
	private static final Logger LOGGER = LogManager.getLogger(ExtentInstance.class.getName());

	@BeforeSuite
	public static ExtentReports createReport() {
		BasicConfigurator.configure();
		Platform platform = PlatformDetection.getOS();
		String[] platformdetails = PlatformDetection.getlocation(platform);
		String reportname = platformdetails[0];
		System.out.println("Location: " + reportname);
		SimpleDateFormat formatter = new SimpleDateFormat("_MM_dd_yyyy(HH_mm_ss)");
		Date date = new Date();

		htmlReport = new ExtentHtmlReporter(reportname + formatter.format(date) + ".html");

		// if extent.config exist use below line to load report details
		htmlReport.loadXMLConfig(System.getProperty("user.dir") + "/" + "extent-config.xml");



		extentReport = new ExtentReports();

		extentReport.attachReporter(htmlReport);

		return extentReport;
	}

	public static ExtentReports getReport() {
		if (extentReport != null) {
			return extentReport;
		} else
			return createReport();

	}

	public static void addScreenshot(String location) {
		try {
			test.log(Status.INFO, "Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(location).build());
		} catch (Exception E) {
			addInfo("Failed to add screenshot.");

		}
	}

	/**
	 * Base 64 screenshots
	 * 
	 * @param location The location of the image
	 */
	public static void addScreenshotB64(String location) {

		String encodedfile;
		try {
			File file = new File(
					System.getProperty("user.dir") + File.separator + "ExtentReports" + File.separator + location);
			FileInputStream fileInputStreamReader = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			fileInputStreamReader.read(bytes);
			encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
			test.log(Status.INFO, "ScreenShot",
					MediaEntityBuilder.createScreenCaptureFromBase64String(encodedfile).build());


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addTest(String testName, String testCategory, ITestResult result) {
		test = classTest.createNode(testName + "_" + result.getMethod().getDescription());
		test.assignCategory(testCategory);
	}

	public static void addSystemInfo() throws UnknownHostException {

		ExtentInstance.getReport().setSystemInfo("Host Name", InetAddress.getLocalHost().getHostName());
		ExtentInstance.getReport().setSystemInfo("OS", System.getProperty("os.name"));
		ExtentInstance.getReport().setSystemInfo("Browser", ConfigManager.getProperty("browser"));
		ExtentInstance.getReport().setSystemInfo("Executed By", System.getProperty("user.name"));

	}

	public static void addInfo(String message) {

		if (test != null) {
			test.log(Status.INFO, message);
		} else {
			classTest.info(message);
		}

	}

	/***
	 * This method cane used when adding info if there is any exceptions
	 * 
	 * @param e
	 */
	public static void addInfo(Throwable e) {
		if (test != null) {
			test.info(e);
		} else {
			classTest.info(e);
		}
	}

	/***
	 * This method cane used when showing API's responses
	 * 
	 * @param markup
	 */
	public static void addInfo(Markup markup) {
		if (test != null) {
			test.log(Status.INFO, markup);
		} else {
			classTest.info(markup);
		}
	}

	public static void addFail(String message) {

		if (test != null) {
			test.log(Status.FAIL, message);
		} else {
			classTest.fail(message);
		}
	}

	public static void addPass(String message) {
		if (test != null) {
			test.log(Status.PASS, message);
		} else {
			classTest.pass(message);
		}
	}

	public static void addSkip(String message) {
		if (test != null) {
			test.log(Status.SKIP, message);
		} else {
			classTest.skip(message);
		}
	}

	public static void addFail(Throwable e) {
		if (test != null) {
			test.fail(e);
		} else {
			classTest.fail(e);
		}
	}

	public static void addSkip(Throwable e) {
		if (test != null) {
			test.skip(e);
		} else {
			classTest.skip(e);
		}
	}

}
