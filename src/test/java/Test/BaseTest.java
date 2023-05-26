package Test;

import Config.ConfigManager;
import Config.StartDriver;
import Pages.LaunchPage;
import Pages.Login;
import Pages.makeAppointment;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utils.extent.ExtentInstance;

import java.net.UnknownHostException;
@Listeners(utils.listeners.Listeners.class)
public class BaseTest {

    Login login;
    WebDriver driver;
    makeAppointment apt;
    LaunchPage lpage;


    @BeforeClass
    public void Setup() throws InterruptedException, UnknownHostException {
        StartDriver.startBrowser(ConfigManager.getProperty("browser"));
//        new LaunchPage(getDriver());
        lpage = new LaunchPage(getDriver());
        login = lpage.NavigateToLogin();
       apt = login.login(ConfigManager.getProperty("username"),ConfigManager.getProperty("password"));
        ExtentInstance.addSystemInfo();
        ExtentInstance.classTest = ExtentInstance.extentReport.createTest(getClass().getName());
       /*return apt;*/

    }
@AfterClass
    public void Quit(){
        driver.quit();
}
private WebDriver getDriver(){
        driver = StartDriver.getDriver();
        return driver;
}
}
