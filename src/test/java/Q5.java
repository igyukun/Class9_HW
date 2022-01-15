import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/*
 Enter https://dgotlieb.github.io/Actions
 Take a screenshot of the box element
 Double click the text “Double-click…” check what happened
and create assertion on result.
 Make a mouse hover on X image.
 Select two items from food list.
 Upload a file.
 Scroll down to “click me button” try both scroll to element
and scroll to location.
 */

public class Q5 {
    private static WebDriver driver;
    public static final String TEST_URL = "https://dgotlieb.github.io/Actions";

    @BeforeClass
    public void initDriver(){
        driver = new InitChrome(TEST_URL).getDriver();
    }

    @Test(priority = 0)
    //Take a screenshot of the box element
    public void takeScreenshot(){
        WebElement box = driver.findElement(By.cssSelector("select[name=food]"));
        File screenShotFile = box.getScreenshotAs(OutputType.FILE); // take the screenshot
        try {
            FileUtils.copyFile(screenShotFile, new File("box.png")); // save screenshot to disk
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    //Double-click the text “Double-click…”
    //New text "You double clicked" will be displayed and checked
    public void doubleClick(){
        String result = "You double clicked";
        WebElement dblClickTxtElement = driver.findElement(By.xpath("/html/body/p[2]"));
        Actions dblClickAct = new Actions(driver);
        dblClickAct.doubleClick(dblClickTxtElement).perform();
        Assert.assertEquals(driver.findElement(By.id("demo")).getText(),result);
    }

    @Test(priority = 2)
    //Make a mouse hover on X image.
    //Check the new height dimension of the "X" image
    public void hoverTest(){
        Actions hoverAct = new Actions(driver);
        WebElement xIcon = driver.findElement(By.id("close"));
        hoverAct.moveToElement(xIcon).perform();
        Assert.assertEquals(xIcon.getRect().getHeight(),64);
    }

    @Test(priority = 3)
    //Select two items from food list.
    public void selectFromList(){
        Actions selectAct = new Actions(driver);
        List<WebElement> listBox = driver.findElements(By.name("kind"));
        selectAct.keyDown(Keys.CONTROL)
                .click(listBox.get(0))
                .click(listBox.get(2))
                .keyUp(Keys.CONTROL)
                .build().perform();
    }

    @Test(priority = 4)
    //Upload a file.
    public void uploadFile(){
        WebElement fileChooser = driver.findElement(By.cssSelector("input[type=file]"));
        fileChooser.sendKeys("C:\\Users\\IGOR\\Documents\\Tashka\\Java\\Class9_HW\\src\\test\\java\\Q5.java");
    }

    @Test (priority = 5)
    //Scroll down to “click me button” try both scroll to element
    //and scroll to location.
    public void scrollTo() throws InterruptedException{
        WebElement clickMe = driver.findElement(By.id("clickMe"));
        //Scroll to an element - "Click Me" button
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",clickMe);
        //Pause the execution to see the scroll down
        Thread.sleep(1500);
        //Scroll to a location - 1,1
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(1,1)");
    }

    @AfterClass
    public void quit(){
      //  driver.quit();
    }
}
