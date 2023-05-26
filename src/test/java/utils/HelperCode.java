package utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.joda.time.format.DateTimeFormatter;

public class HelperCode {
    WebDriver driver;
        public static String getDateUTCPlusMinusWeeks (String dateFormat,int noOfdays) {

            DateTime dateTime = new DateTime( DateTimeZone.UTC );
            DateTimeFormatter dtfOut = DateTimeFormat.forPattern(dateFormat);
            return dtfOut.print(dateTime.plusDays(noOfdays));
        }

    public void SelectFacility(WebElement el,String item){
        Select sl = new Select(el);
        sl.selectByVisibleText(item);
    }
}

