package Test;

import Pages.AppointmentConfirmation;
import Pages.makeAppointment;
import Utils.HelperCode;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestAppointment extends BaseTest{
    makeAppointment mApt;
    AppointmentConfirmation aptConf;
/*@BeforeClass
public void Test() throws InterruptedException {

}*/

    @Test
    public void CreateAppointment(){
        mApt = new makeAppointment(driver);
        HashMap <String, String> AptFilldata = new HashMap<>();
        AptFilldata.put("Facility", "Hongkong CURA Healthcare Center");
        AptFilldata.put("isReadmission", "Yes");
        AptFilldata.put("healthcare","Medicare");
        AptFilldata.put("VisitDate","2");
        AptFilldata.put("Comment","Creating Appointment for Hongkong CURA");
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
    }

@AfterMethod
    public void BackToAptPage(){
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/#appointment");
}

}
