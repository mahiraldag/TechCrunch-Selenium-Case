package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseUtil;

import java.time.Duration;

public class NewsDetailsPage extends BaseUtil {
    private WebDriver driver;
    String browserTitle;

    // Elements locators
    private By firstLatestNewsTitle = By.xpath("//*[@id=\"tc-main-content\"]/div[3]/div/div/div/article[1]");
    private By firstLatestNewsTitleInDetailsPage = By.xpath("//*[@id=\"tc-main-content\"]/div[3]/div/div/div/article[1]/div[2]/div[2]/div[1]/header/div[1]/h1");
    private By copyShareLink = By.xpath("//*[@id=\"tc-main-content\"]/div[3]/div/div/div/article[1]/div[2]/div[1]/div/a[6]");
    private By linkCopiedText = By.xpath("//*[contains(text(), 'Link Copied')]");


    public NewsDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstArticleTitle(){
        WebElement articleTitle = driver.findElement(firstLatestNewsTitleInDetailsPage);
        // System.out.println("article title " + articleTitle.getText());
        return articleTitle.getText();
    }

    public String getBrowserTitle(){
        WebElement firstArticle = driver.findElement(firstLatestNewsTitle);
        firstArticle.click();
        browserTitle = driver.getTitle();
        //  System.out.println(browserTitle);
        return browserTitle;
    }

    public void verifyCopyLinkButton(){
        driver.findElement(firstLatestNewsTitle).click();
        driver.findElement(copyShareLink).isDisplayed();
        driver.findElement(copyShareLink).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkCopiedText));
    }
}
