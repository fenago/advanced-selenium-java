package testing;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NewTest {

    private WebDriver driver;

    @Test
    public void testEasy() {
        driver.get("https://www.facebook.com/");
        String title = driver.getTitle();
        assertTrue(title.contains("Facebook"));
    }
    @BeforeMethod
    public void setUp() {
        // Uncomment following lines to use firefox instead of HtmlUnitDriver
        // System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\drivers\\firefox\\geckodriver.exe");
        // driver = new FirefoxDriver();
        
        driver = new HtmlUnitDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}