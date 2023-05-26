package Config;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import utils.extent.PlatformDetection;


public class Utility {

	public static String getCurrentDateAndTime() {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		return dateName;

	}

	public static void waitUntilFound(WebDriver driver, WebElement el, int timeout) {
		try {
			WebElement x = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOf(el));
		} catch (Exception e) {
			printExceptionMessages(e, "wait until found");
		}
	}

	private static void printExceptionMessages(Exception e, String methodName) {
		System.out.println("This is the element  " + methodName + " exception message");
		System.out.println(e.getMessage());
		System.out.println("This is the end of the  " + methodName + "  exception " + "message");
	}

	public static String captureScreenshot(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileName = "";
		try {
			// now copy the screenshot to desired location using copyFile //method
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
			String stringDate = dateFormat.format(new Date());
			String saveLocation = PlatformDetection.getlocation(PlatformDetection.getOS())[1] + "screenshot"
					+ stringDate + ".png";
			fileName = saveLocation
					.replace(System.getProperty("user.dir") + File.separator + "ExtentReports" + File.separator, "");
			FileUtils.copyFile(src, new File(saveLocation));
			Reporter.log("<a href=\"" + "file:///" + System.getProperty("user.dir") + "/screenshots/" + fileName
					+ "\">Screenshot</a>");
		} catch (IOException e) {	
			System.out.println(e.getMessage());
		}
		return fileName;
	}
}
