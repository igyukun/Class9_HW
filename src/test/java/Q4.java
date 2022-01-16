import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Q4 {
    public static final String TEST_URL = "https://dgotlieb.github.io/WebCalculator/";

    @Test
    public static void startBrowserNoExtensions() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\IGOR\\Documents\\Studies\\QA Experts\\WebDrivers\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
        options.addArguments("--disable-extensions");
        WebDriver driver = new ChromeDriver(options);
        driver.get(TEST_URL);
    }
}
