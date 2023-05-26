package Test;

import Pages.AppointmentConfirmation;
import Pages.makeAppointment;
import org.testng.annotations.DataProvider;
import utils.HelperCode;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.extent.ExtentInstance;

import java.util.HashMap;

public class TestAppointment extends BaseTest{
    makeAppointment mApt;
    AppointmentConfirmation aptConf;
/*@BeforeClass
public void Test() throws InterruptedException {

}*/


    @Test(dataProvider="CreateAppointment")
    public void CreateAppointment(String fact, String isRed, String hltCare, String vDate, String cmnt){
        ExtentInstance.addInfo("Running create Appointment Testcases");
        mApt = new makeAppointment(driver);
        HashMap <String, String> AptFilldata = new HashMap<>();
        AptFilldata.put("Facility", fact);
        AptFilldata.put("isReadmission", isRed);
        AptFilldata.put("healthcare", hltCare);
        AptFilldata.put("VisitDate", vDate);
        AptFilldata.put("Comment", cmnt);
        ExtentInstance.addInfo("Running create Appointment Testcases for data"+AptFilldata);
        mApt.FillData(AptFilldata);
        aptConf = mApt.BookAppointment();
        aptConf.facility.getText();
        Assert.assertEquals( aptConf.facility.getText(), AptFilldata.get("Facility"));
        ExtentInstance.addInfo("Facility Validation done");
        Assert.assertEquals( aptConf.ApplyForHospitalReadmission.getText(), AptFilldata.get("isReadmission"));
        ExtentInstance.addInfo("Readmission Validation done");
        Assert.assertEquals( aptConf.HealthcareProgram.getText(), AptFilldata.get("healthcare"));
        ExtentInstance.addInfo("healtcare Validation done");
        Assert.assertEquals(aptConf.Date.getText().trim(), HelperCode.getDateUTCPlusMinusWeeks("dd/MM/yyyy", Integer.parseInt(AptFilldata.get("VisitDate"))));
        ExtentInstance.addInfo("date Validation done");
        Assert.assertEquals( aptConf.Comment.getText(), AptFilldata.get("Comment"));
        ExtentInstance.addInfo("Comment Validation done");
        ExtentInstance.addPass("Appointment created");

    }
/*
    @Test
    public void CreateApptTokyoMedicaid(){
        mApt = new makeAppointment(driver);
        HashMap <String, String> AptFilldata = new HashMap<>();
        AptFilldata.put("Facility", "Tokyo CURA Healthcare Center");
        AptFilldata.put("isReadmission", "No");
        AptFilldata.put("healthcare","Medicaid");
        AptFilldata.put("VisitDate","4");
        AptFilldata.put("Comment","Creating Appointment for Tokyo CURA");
        mApt.FillData(AptFilldata);
        aptConf = mApt.BookAppointment();
        aptConf.facility.getText();
        Assert.assertEquals( aptConf.facility.getText(), AptFilldata.get("Facility"));
        Assert.assertEquals( aptConf.ApplyForHospitalReadmission.getText(), AptFilldata.get("isReadmission"));
        Assert.assertEquals( aptConf.HealthcareProgram.getText(), AptFilldata.get("healthcare"));
        Assert.assertEquals(aptConf.Date.getText().trim(), HelperCode.getDateUTCPlusMinusWeeks("dd/MM/yyyy", Integer.parseInt(AptFilldata.get("VisitDate"))));
        Assert.assertEquals( aptConf.Comment.getText(), AptFilldata.get("Comment"));
    }

    @Test
    public void CreateApptTokyoNone() {
        mApt = new makeAppointment(driver);
        HashMap<String, String> AptFilldata = new HashMap<>();
        AptFilldata.put("Facility", "Tokyo CURA Healthcare Center");
        AptFilldata.put("isReadmission", "Yes");
        AptFilldata.put("healthcare", "None");
        AptFilldata.put("VisitDate", "2");
        AptFilldata.put("Comment", "Creating Appointment for Tokyo CURA");
        mApt.FillData(AptFilldata);
        aptConf = mApt.BookAppointment();
        aptConf.facility.getText();
        Assert.assertEquals(aptConf.facility.getText(), AptFilldata.get("Facility"));
        Assert.assertEquals( aptConf.ApplyForHospitalReadmission.getText(), AptFilldata.get("isReadmission"));
        Assert.assertEquals( aptConf.HealthcareProgram.getText(), AptFilldata.get("healthcare"));
        Assert.assertEquals(aptConf.Date.getText().trim(), HelperCode.getDateUTCPlusMinusWeeks("dd/MM/yyyy", Integer.parseInt(AptFilldata.get("VisitDate"))));
        Assert.assertEquals( aptConf.Comment.getText(), AptFilldata.get("Comment"));
    }

        @Test
        public void CreateApptTokyoMedicare(){
            mApt = new makeAppointment(driver);
            HashMap <String, String> AptFilldata = new HashMap<>();
            AptFilldata.put("Facility", "Tokyo CURA Healthcare Center");
            AptFilldata.put("isReadmission", "Yes");
            AptFilldata.put("healthcare","Medicare");
            AptFilldata.put("VisitDate","3");
            AptFilldata.put("Comment","Creating Appointment for Tokyo CURA");
            mApt.FillData(AptFilldata);
            aptConf = mApt.BookAppointment();
            aptConf.facility.getText();
            Assert.assertEquals( aptConf.facility.getText(), AptFilldata.get("Facility"));
            Assert.assertEquals( aptConf.ApplyForHospitalReadmission.getText(), AptFilldata.get("isReadmission"));
            Assert.assertEquals( aptConf.HealthcareProgram.getText(), AptFilldata.get("healthcare"));
            Assert.assertEquals(aptConf.Date.getText().trim(), HelperCode.getDateUTCPlusMinusWeeks("dd/MM/yyyy", Integer.parseInt(AptFilldata.get("VisitDate"))));
            Assert.assertEquals( aptConf.Comment.getText(), AptFilldata.get("Comment"));
    }

    @Test
    public void CreateApptSeoulMedicaid(){
        mApt = new makeAppointment(driver);
        HashMap <String, String> AptFilldata = new HashMap<>();
        AptFilldata.put("Facility", "Seoul CURA Healthcare Center");
        AptFilldata.put("isReadmission", "Yes");
        AptFilldata.put("healthcare","Medicaid");
        AptFilldata.put("VisitDate","4");
        AptFilldata.put("Comment","Creating Appointment for Seoul CURA");
        mApt.FillData(AptFilldata);
        aptConf = mApt.BookAppointment();
        aptConf.facility.getText();
        Assert.assertEquals( aptConf.facility.getText(), AptFilldata.get("Facility"));
        Assert.assertEquals( aptConf.ApplyForHospitalReadmission.getText(), AptFilldata.get("isReadmission"));
        Assert.assertEquals( aptConf.HealthcareProgram.getText(), AptFilldata.get("healthcare"));
        Assert.assertEquals(aptConf.Date.getText().trim(), HelperCode.getDateUTCPlusMinusWeeks("dd/MM/yyyy", Integer.parseInt(AptFilldata.get("VisitDate"))));
        Assert.assertEquals( aptConf.Comment.getText(), AptFilldata.get("Comment"));
    }

    @Test
    public void CreateApptSeoulNone(){
        mApt = new makeAppointment(driver);
        HashMap <String, String> AptFilldata = new HashMap<>();
        AptFilldata.put("Facility", "Seoul CURA Healthcare Center");
        AptFilldata.put("isReadmission", "Yes");
        AptFilldata.put("healthcare","None");
        AptFilldata.put("VisitDate","4");
        AptFilldata.put("Comment","Creating Appointment for Seoul CURA");
        mApt.FillData(AptFilldata);
        aptConf = mApt.BookAppointment();
        aptConf.facility.getText();
        Assert.assertEquals( aptConf.facility.getText(), AptFilldata.get("Facility"));
        Assert.assertEquals( aptConf.ApplyForHospitalReadmission.getText(), AptFilldata.get("isReadmission"));
        Assert.assertEquals( aptConf.HealthcareProgram.getText(), AptFilldata.get("healthcare"));
        Assert.assertEquals(aptConf.Date.getText().trim(), HelperCode.getDateUTCPlusMinusWeeks("dd/MM/yyyy", Integer.parseInt(AptFilldata.get("VisitDate"))));
        Assert.assertEquals( aptConf.Comment.getText(), AptFilldata.get("Comment"));
    }

    @Test
    public void CreateApptSeoulMedicare(){
        mApt = new makeAppointment(driver);
        HashMap <String, String> AptFilldata = new HashMap<>();
        AptFilldata.put("Facility", "Seoul CURA Healthcare Center");
        AptFilldata.put("isReadmission", "No");
        AptFilldata.put("healthcare","Medicare");
        AptFilldata.put("VisitDate","5");
        AptFilldata.put("Comment","Creating Appointment for Seoul CURA");
        mApt.FillData(AptFilldata);
        aptConf = mApt.BookAppointment();
        aptConf.facility.getText();
        Assert.assertEquals( aptConf.facility.getText(), AptFilldata.get("Facility"));
        Assert.assertEquals( aptConf.ApplyForHospitalReadmission.getText(), AptFilldata.get("isReadmission"));
        Assert.assertEquals( aptConf.HealthcareProgram.getText(), AptFilldata.get("healthcare"));
        Assert.assertEquals(aptConf.Date.getText().trim(), HelperCode.getDateUTCPlusMinusWeeks("dd/MM/yyyy", Integer.parseInt(AptFilldata.get("VisitDate"))));
        Assert.assertEquals( aptConf.Comment.getText(), AptFilldata.get("Comment"));
    }*/

@AfterMethod
    public void BackToAptPage(){
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/#appointment");
}
    @DataProvider(name="CreateAppointment")
    public Object[][] getDataFromDataprovider(){
        return new Object[][]
                {
                        { "Seoul CURA Healthcare Center", "No" , "Medicare", "5", "Creating Appointment for Seoul CURA" },
                        { "Tokyo CURA Healthcare Center", "Yes" , "Medicare", "3", "Creating Appointment for Seoul Tokyo" },
                        { "Hongkong CURA Healthcare Center", "No" , "Medicare", "2", "Creating Appointment for Seoul Hongkong CURA Healthcare Center" },
                        { "Seoul CURA Healthcare Center", "No" , "None", "5", "Creating Appointment for Seoul CURA" },
                        { "Tokyo CURA Healthcare Center", "Yes" , "None", "3", "Creating Appointment for Seoul Tokyo" },
                        { "Hongkong CURA Healthcare Center", "No" , "None", "2", "Creating Appointment for Seoul Hongkong CURA Healthcare Center" },
                        { "Seoul CURA Healthcare Center", "Yes" , "Medicaid", "7", "Creating Appointment for Seoul CURA" },
                        { "Tokyo CURA Healthcare Center", "No" , "Medicaid", "9", "Creating Appointment for Seoul Tokyo" },
                        { "Hongkong CURA Healthcare Center", "Yes" , "Medicaid", "1", "Creating Appointment for Seoul Hongkong CURA Healthcare Center" }
                };

    }
}
