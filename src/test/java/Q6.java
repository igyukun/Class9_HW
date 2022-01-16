import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 Open https://dgotlieb.github.io/Controllers/
 Select “Cheese option” in radio buttons.
 Select one of the options from the drop down below.
 Print all elements in drop down.
 */

public class Q6 {
    private static WebDriver driver;
    public static final String TEST_URL = "https://dgotlieb.github.io/Controllers/";

    @BeforeClass
    public void initDriver(){
        driver = new InitChrome(TEST_URL).getDriver();
    }

    @Test(priority = 0)
    //Selecting “Cheese option” in radio buttons.
    public void selectCheese(){
        WebElement cheeseSel = driver.findElement(By.cssSelector("input[value=Cheese]"));
        Actions clickCheeseAct = new Actions(driver);
        clickCheeseAct.click(cheeseSel).perform();
    }

    @Test(priority = 1)
    //Selecting one of the options from the drop down
    public void selectItem(){
        Select dropDown = new Select(driver.findElement(By.name("dropdownmenu")));
        dropDown.selectByVisibleText("Cheese");
    }

    @Test(priority = 2)
    //Printing all elements in drop down and displaying in alert box
    public void printElements(){
        String optionsList = String.format("The options are: ");
        Select dropDown = new Select(driver.findElement(By.name("dropdownmenu")));

        for (WebElement w: dropDown.getOptions()){
            optionsList += String.format(" %s ",w.getText());
        }
        System.out.println(optionsList);
        ((JavascriptExecutor)driver).executeScript(String.format("alert('%s');",optionsList));
    }

}
