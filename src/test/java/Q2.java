import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.PortUnreachableException;

/*
Create a test that assert** Website URL
Prepare strings variable containing the title and URL before
 */

public class Q2 {

    private static WebDriver driver;
    public static final String TEST_URL = "https://dgotlieb.github.io/WebCalculator/";
    public static final String TITLE = "Calculator";

    @BeforeClass
    public void initDriver(){
        driver = new InitChrome(TEST_URL).getDriver();
    }

    @Test
    public void assertURL(){
        Assert.assertEquals(driver.getCurrentUrl(),TEST_URL);
    }

    @Test
    public void assertTitle(){
        Assert.assertEquals(driver.getTitle(),TITLE);
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
