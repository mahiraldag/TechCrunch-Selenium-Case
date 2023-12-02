package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        // Set up ChromeOptions to disable popups
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");  // This should be activated before pushing .yml file
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        // Use the ChromeOptions when creating the ChromeDriver instance
        driver = new ChromeDriver(options);

        // Set up which page driver be set to
        driver.get("https://techcrunch.com/");

        // Set timeout for all tests
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown() {
        // Close the WebDriver instance
        if (driver != null) {
            //driver.close();
            driver.quit();
        }
    }
}
