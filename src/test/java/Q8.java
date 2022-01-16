import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 Open any browser on "The Marker" website.
 https://www.themarker.com/
 Check how many times the word "news" exists in the page
source.
 Hint: use driver.getPageSource() method.
 */

public class Q8 {
    private static WebDriver driver;
    public static final String TEST_URL = "https://www.themarker.com/";
    public static final String FIND_STRING = "news";

    @BeforeClass
    public void initDriver(){
        driver = new InitChrome(TEST_URL).getDriver();
    }

    @Test(priority = 0)
    public void countNews(){
        String pageSource = driver.getPageSource();
        int count = 0;
        int index = 0;
        while ((index = pageSource.indexOf(FIND_STRING, index)) != -1) {
            count++;
            index += FIND_STRING.length();
        }
        System.out.printf("\"News\" word appears %d times",count);
    }
}

