package Pages;

import Config.StartDriver;
import Utils.HelperCode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;

public class makeAppointment {
    WebDriver driver;
     HelperCode helperCode = new HelperCode();
@FindBy(xpath = "//h2[text() = \"Make Appointment\"]")
protected static WebElement MakeAPteLbl;
    @FindBy(id = "combo_facility")
    protected static WebElement Facility;
    @FindBy(id = "chk_hospotal_readmission")
    protected static WebElement isReadmission;
    @FindBy(id = "radio_program_medicare")
    protected static WebElement radioMedicare;
    @FindBy(id = "radio_program_medicaid")
    protected static WebElement radioMedicaid;
    @FindBy(id = "radio_program_none")
    protected static WebElement radioNone;
    @FindBy(id = "txt_visit_date")
    protected static WebElement VisitDate;
    @FindBy(id = "txt_comment")
    protected static WebElement CommentTxt;
    @FindBy(id = "btn-book-appointment")
    protected static WebElement BookAppointment;

/*
@BeforeClass
public void Setup(){
    helperCode = new HelperCode();
*/
/*}*/
    public makeAppointment(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Assert.assertEquals("Make Appointment",MakeAPteLbl.getText());
    }

    public void FillData(HashMap<String,String> AptData) {

        helperCode.SelectFacility(Facility, AptData.get("Facility"));
        if (AptData.get("isReadmission").equalsIgnoreCase("Yes"))
            isReadmission.click();

        if (AptData.get("healthcare").equalsIgnoreCase("medicare"))
        {
            radioMedicare.click();
        }
else if (AptData.get("healthcare").equalsIgnoreCase("Medicaid")){
        radioMedicaid.click();
}
else
            radioNone.click();

        VisitDate.sendKeys(HelperCode.getDateUTCPlusMinusWeeks("dd/MM/yyyy", Integer.parseInt(AptData.get("VisitDate"))));
        CommentTxt.sendKeys(AptData.get("Comment"));

    }
public AppointmentConfirmation BookAppointment()
{
    BookAppointment.click();
    return new AppointmentConfirmation(StartDriver.getDriver());
}

}
