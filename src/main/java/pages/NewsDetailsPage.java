package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class NewsDetailsPage {
    private WebDriver driver;

    // Elements locators
    private By firstArticleTitleInDetailsPageLocator = By.xpath("//*[@id=\"tc-main-content\"]/div[3]/div/div/div/article[1]/div[2]/div[2]/div[1]/header/div[1]/h1");
    private By articleContentLocator = By.className("article-content");

    public NewsDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstArticleTitle() {
        WebElement articleTitle = driver.findElement(firstArticleTitleInDetailsPageLocator);
       // System.out.println("article title " + articleTitle.getText());
        return articleTitle.getText();
       // return articleTitle.getText() +  " | TechCrunch";
    }

    public String getBrowserTitle() {
        // System.out.println(browserTitle);
        return driver.getTitle();
    }

    public Boolean verifyLinksWithinNewsContent() {
        WebElement newsContent = driver.findElement(articleContentLocator);
        List<WebElement> links = newsContent.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (!isValidURL(url)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidURL(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
           // connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
           System.out.println(responseCode + " and " + url);
            return (200 == responseCode);
        } catch (Exception e) {
            return false;
        }
    }
}
