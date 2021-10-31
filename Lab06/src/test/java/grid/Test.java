package grid;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


/**
 * Created by fenago
 */
public class Test {
    static WebDriver driver;

    //Setup Driver
    @BeforeClass
    public static void setupTest() {

        // FIREFOX
        //  System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\drivers\\firefox\\geckodriver.exe");
        //  driver = new FirefoxDriver();


        //CHROME
        String chromeDriverLocation = "C:\\Selenium\\drivers\\chrome\\chromedriver.exe";
        System.out.println("Chrome Driver: " + chromeDriverLocation );
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        driver = new ChromeDriver();
    }

    @org.junit.Test
    public void T01_BasicActionsTest() {
        //Navigate to facebook.com
        driver.navigate().to("https://web.facebook.com/");
        driver.manage().window().maximize();

        //Enter input
        WebElement emailId = driver.findElement(By.id("email"));
        emailId.sendKeys("selenium");
        WebElement password = driver.findElement(By.id("pass"));
        emailId.sendKeys("selenium");
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
