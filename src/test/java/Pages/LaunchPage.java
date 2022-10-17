package Pages;

import Config.StartDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaunchPage {

    WebDriver driver;
    @FindBy(id = "btn-make-appointment")
    protected static WebElement MakeAppointent;


    public LaunchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Login NavigateToLogin() {
        MakeAppointent.click();
        return new Login(StartDriver.getDriver());
    }
}