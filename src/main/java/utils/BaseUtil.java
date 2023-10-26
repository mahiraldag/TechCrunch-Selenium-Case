package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseUtil {
    protected WebDriver driver;
    private String driverPath = "/usr/local/bin/chromedriver";
    private String driverName= "webdriver.chrome.driver";


    @BeforeClass
    public void setup() {
        // Use WebDriverManager to handle ChromeDriver setup
        //WebDriverManager.chromedriver().browserVersion("118.0.5993.88").setup();
        System.setProperty(driverName, driverPath);

        // Set up ChromeOptions to disable popups
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        // Use the ChromeOptions when creating the ChromeDriver instance
        this.driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown() {
        // Close the WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }


}
