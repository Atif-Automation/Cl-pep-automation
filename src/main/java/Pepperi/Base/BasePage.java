package Pepperi.Base;

import PepperiUtilites.TimeUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    public WebDriver driver;
    public Properties prop;

    /**
     * This method is use to initialize the WebDriver
     * @param prop
     * @return
     */

    public WebDriver initialize_driver(Properties prop){

        String browserName = prop.getProperty("browser");
        if (browserName.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browserName.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("no browser" +browserName+ "is defined");
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        TimeUtil.mediumWait();
        return driver;

    }

    public Properties initialize_Properties()  {

        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("C:\\Users\\MuhammadAtif(Externa\\Downloads\\cl-pep-automation+" +
                    "\\src\\main\\java\\com\\qa\\pepperi\\configuration\\config.properties");
            prop.load(ip);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }
}
