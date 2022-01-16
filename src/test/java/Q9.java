import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
Using JavaScriptExecutor
 Print the current page (The same as if you pressed file 
print in your browser).
 */

public class Q9 {
    private static WebDriver driver;
    public static final String TEST_URL = "https://dgotlieb.github.io/WebCalculator/";

    @BeforeClass
    public void initDriver(){
        driver = new InitChrome(TEST_URL).getDriver();
    }

    @Test
    public void printPageWithJS(){
        ((JavascriptExecutor)driver).executeScript("window.print();");
    }
}
