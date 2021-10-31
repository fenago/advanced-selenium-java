package grid;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by fenago
 */
public class GridExampleTest {

    static WebDriver driver;

    //Setup Driver
    @BeforeClass
    public static void setupTest() throws MalformedURLException {
        /*String chromeDriverLocation = "C:\\Selenium\\drivers\\chrome\\chromedriver.exe";
        System.out.println("Chrome Driver: " + chromeDriverLocation );
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        driver = new ChromeDriver();*/
        /*DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setPlatform(Platform.WINDOWS);

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);*/

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setPlatform(Platform.WINDOWS);

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
    }

    @Test
    public void T01_FacebookLogin() {
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
