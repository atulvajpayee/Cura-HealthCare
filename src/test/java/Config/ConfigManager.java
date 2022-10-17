package Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.SkipException;

/*import util.extent.ExtentInstance;*/

public class ConfigManager {

    static Properties prop = new Properties();
    static FileInputStream fis = null;

    public static String getProperty(String s) {

        String str = "";
        File file = new File("/Users/atul.vajpayee/IdeaProjects/CURA/src/test/java/Resources/config.properties");

        try {
            fis = new FileInputStream(file);
            if (fis != null) {
                try {
                    prop.load(fis);
                    str = prop.get(s).toString();
                    if (str == " ")
                        throw new SkipException("keys value" + s + "not present in config file");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return str;
    }

}