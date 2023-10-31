package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    // Elements locators
    private By latestArticlesSectionLocator = By.cssSelector(".content-wrap:has(.river__title--home)");
    private By articleBlocksLocator = By.cssSelector(".post-block post-block--image");
    private By firstArticleTitleLocator = By.xpath("//*[@id=\"tc-main-content\"]/div[3]/div/div/div/article[1]");
    private By latestArticlesLocator = By.cssSelector(".river--homepage article");
    private By articleAuthorLocator = By.cssSelector(".river--homepage .river-byline__authors a");
    private By articleImageLocator = By.cssSelector(".post-block__media img");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean eachNewsHasAuthor() {
        WebElement section = driver.findElement(latestArticlesSectionLocator);
        List<WebElement> articles = section.findElements(articleBlocksLocator);

        for (WebElement article : articles) {
            if (article.findElements(articleAuthorLocator).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean eachNewsHasImage() {
        WebElement section = driver.findElement(latestArticlesSectionLocator);
        List<WebElement> articles = section.findElements(articleBlocksLocator);

        for (WebElement article : articles) {
            if (article.findElements(articleImageLocator).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void goToNewsDetails(){
        driver.findElement(firstArticleTitleLocator).click();
    }
}
