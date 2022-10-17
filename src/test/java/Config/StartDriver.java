package Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class StartDriver {
    private static WebDriver driver;

    public static void startBrowser(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("Firefox")) {
           WebDriverManager.firefoxdriver().setup();
           driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("Edge")) {
           WebDriverManager.edgedriver().setup();
           driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
           WebDriverManager.safaridriver().setup();
           driver = new SafariDriver();
        }

        driver.get(ConfigManager.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

    }
public static WebDriver getDriver(){
       if (driver == null) {
          startBrowser(ConfigManager.getProperty("browser"));
       }
       return driver;
}
}
