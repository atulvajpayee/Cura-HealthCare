package Pages;

import Config.StartDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;
    @FindBy(id = "txt-username")
    protected WebElement usernameTxt;

    @FindBy(id = "txt-password")
    protected WebElement passwordTxt;

    @FindBy(id = "btn-login")
    protected WebElement loginBtn;

public Login(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
}

public makeAppointment login(String username, String password) throws InterruptedException {
    usernameTxt.sendKeys(username);
    passwordTxt.sendKeys(password);
    loginBtn.click();
    Thread.sleep(3000);
    return new makeAppointment(StartDriver.getDriver());

}
}
