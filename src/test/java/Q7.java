import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 Enter https://dgotlieb.github.io/WebCalculator/
 Print “2” button height.
 Print “6” button width.
 */
public class Q7 {
    private static WebDriver driver;
    public static final String TEST_URL = "https://dgotlieb.github.io/WebCalculator/";

    @BeforeClass
    public void initDriver(){
        driver = new InitChrome(TEST_URL).getDriver();
    }

    @Test(priority = 0)
    //Print “2” button height
    public void getButtonHight(){
        WebElement button = driver.findElement(By.id("two"));
        int height = button.getRect().getHeight();
        System.out.printf("Button 2 height is %d px. %n", height);
        Assert.assertEquals(height,36);
    }

    @Test(priority = 1)
    //Print “6” button width
    public void getButtonWidth(){
        WebElement button = driver.findElement(By.id("six"));
        int width = button.getRect().getWidth();
        System.out.printf("Button 2 height is %d px. %n", width);
        Assert.assertEquals(width,65);
    }


}
