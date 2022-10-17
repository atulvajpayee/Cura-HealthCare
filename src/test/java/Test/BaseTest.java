package Test;

import Config.ConfigManager;
import Config.StartDriver;
import Pages.LaunchPage;
import Pages.Login;
import Pages.makeAppointment;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    Login login;
    WebDriver driver;
    makeAppointment apt;
    LaunchPage lpage;

    @BeforeClass
    public void Setup() throws InterruptedException {
        StartDriver.startBrowser(ConfigManager.getProperty("browser"));
//        new LaunchPage(getDriver());
        lpage = new LaunchPage(getDriver());
        login = lpage.NavigateToLogin();
       apt = login.login(ConfigManager.getProperty("username"),ConfigManager.getProperty("password"));
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
