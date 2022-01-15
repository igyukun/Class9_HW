import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 Create a String variable with the website’s title
 Refresh website
Get website title and use assertion to test if website’s name is equal to
the String variable you created in clause 1. */

public class Q3 {

    private static WebDriver driver;
    public static final String TEST_URL =
            "https://stackoverflow.com/questions/34222412/load-chrome-extension-using-selenium";
    public static final String TITLE = "Load chrome extension using selenium - Stack Overflow";
    
    @BeforeClass
    public void initDriver(){
        driver = new InitChrome(TEST_URL).getDriver();
    }

    @Test
    public void checkTitleAfterRefresh(){
        driver.navigate().refresh();
        String titleAfter = driver.getTitle();
        Assert.assertEquals(TITLE,titleAfter);
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
