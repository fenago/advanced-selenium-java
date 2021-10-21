package grid.ParallelComputerGrid;

import org.junit.After;
import org.junit.Test;

import java.net.MalformedURLException;

/**
 * Created by fenago
 */
//Second Test Class
public  class ParallelTest2 extends DriverManager {

    //Chrome Test
    @Test
    public void testChrome2() throws MalformedURLException {
        driver = new DriverManager().getDriver("chrome");
        driver.navigate().to("http://www.yahoo.com/");
        driver.manage().window().maximize();
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}