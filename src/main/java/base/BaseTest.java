package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    private String driverPath = "/usr/local/bin/chromedriver";
    private String driverName= "webdriver.chrome.driver";

    @BeforeClass
    public void setup() {
        System.setProperty(driverName, driverPath);

        // Set up ChromeOptions to disable popups
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("headless");
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
