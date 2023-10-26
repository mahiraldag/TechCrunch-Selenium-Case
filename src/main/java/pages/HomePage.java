package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BaseUtil;

import java.net.MalformedURLException;
import java.util.List;

public class HomePage extends BaseUtil {
    private WebDriver driver;

    // Elements locators
    private By latestArticlesSection = By.cssSelector(".content-wrap:has(.river__title--home)");
    private By articleBlocks = By.cssSelector(".post-block post-block--image");
    private By latestArticles = By.cssSelector(".river--homepage article");
    private By articleAuthor = By.cssSelector(".river--homepage .river-byline__authors a");
    private By articleImage = By.cssSelector(".post-block__media img");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public int getNumberOfArticles() {
        WebElement section = driver.findElement(latestArticlesSection);
        List<WebElement> articles = section.findElements(latestArticles);
        /*for (WebElement article : articles) {
            System.out.println(articles.getText());
        }*/
        return articles.size();
    }

    public int getNumberAuthors() {
        List<WebElement> authorList = driver.findElements(articleAuthor);
       /* for (WebElement author : authorList) {
            System.out.println(author.getText());
        }*/
        if (authorList.size() > 20){
            return 20;
        }else{
            return authorList.size();
        }
    }


    public int getNumberOfImages() throws MalformedURLException {
        WebElement section = driver.findElement(latestArticlesSection);
        List<WebElement> imageList = section.findElements(articleImage);
        /*for (WebElement image : imageList) {
            String imageUrl = image.getAttribute("src");
            String imageName = new URL(imageUrl).getPath();
            imageName = imageName.substring(imageName.lastIndexOf("/") + 1);
            System.out.println(imageName);
        }*/
        if (imageList.size() > 20){
            return 20;
        }else{
            return imageList.size();
        }
    }


    public boolean eachNewsHasAuthor() {
        WebElement section = driver.findElement(latestArticlesSection);
        List<WebElement> articles = section.findElements(articleBlocks);

        for (WebElement article : articles) {
            if (article.findElements(articleAuthor).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean eachNewsHasImage() {
        WebElement section = driver.findElement(latestArticlesSection);
        List<WebElement> articles = section.findElements(articleBlocks);

        for (WebElement article : articles) {
            if (article.findElements(articleImage).isEmpty()) {
                return false;
            }
        }
        return true;
    }


}
