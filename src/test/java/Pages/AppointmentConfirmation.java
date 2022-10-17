package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentConfirmation {
    WebDriver driver;
    @FindBy(xpath = "//label[@for='facility']/../following-sibling::div/p[@id='facility']")
    public WebElement facility;

    @FindBy(xpath = "//label[@for='hospital_readmission']/../following-sibling::div/p[@id='hospital_readmission']")
    public WebElement ApplyForHospitalReadmission;

    @FindBy(xpath = "//label[@for='program']/../following-sibling::div/p[@id='program']")
    public WebElement HealthcareProgram;

    @FindBy(xpath = "//label[@for='visit_date']/../following-sibling::div/p[@id='visit_date']")
    public WebElement Date;

    @FindBy(xpath = "//label[@for='comment']/../following-sibling::div/p[@id='comment']")
    public WebElement Comment;

    public AppointmentConfirmation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

