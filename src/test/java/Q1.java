import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class Q1 {

    private static WebDriver driver;
    public static final String TEST_URL = "https://dgotlieb.github.io/WebCalculator/";

    @BeforeClass
    public void initDriver(){
        driver = new InitChrome(TEST_URL).getDriver();
    }

    @Test(priority = 0)
    //Print “7” button dimensions.
    public void button_7_dimentions(){
        WebElement button = driver.findElement(By.cssSelector("span[id=seven]"));
        System.out.printf("Button7 width is %d, height is %d.", button.getRect().getWidth(),
                button.getRect().getHeight());
    }

    @Test(priority = 1)
    //Check if “6” button is displayed
    public void checkButton6(){
        Assert.assertNotEquals(driver.findElement(By.cssSelector("span[id=six]")).isDisplayed(),true);
    }

    @Test(priority = 2)
    // Prepare a String variable with any number
    // Calculate a mathematical formula that will give the result
    //   you choose in the String variable earlier.
    // Use assert to check if you got the expected result
    public void checkCalculation(){
        String result = "11";
        WebElement button5, button6, buttonPlus, buttonEqual, resultField;
        button5 = driver.findElement(By.cssSelector("span[id=five]"));
        button6 = driver.findElement(By.cssSelector("span[id=six]"));
        buttonPlus = driver.findElement(By.cssSelector("span[id=add]"));
        buttonEqual = driver.findElement(By.cssSelector("span[id=equal]"));
        resultField = driver.findElement(By.cssSelector("div[id=screen]"));
        Actions action = new Actions(driver);
        action.click(button5)
                .click(buttonPlus)
                .click(button6)
                .click(buttonEqual)
                .build().perform();
        Assert.assertEquals(result,resultField.getText());
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
