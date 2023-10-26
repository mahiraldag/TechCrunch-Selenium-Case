package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.BaseUtil;

import java.net.MalformedURLException;

public class HomePageTest extends BaseUtil {
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        super.setup();
        driver.get("https://techcrunch.com/");
        homePage = new HomePage(driver);
    }

    @Test
    public void verifyEachLatestNewsHasAuthor() throws MalformedURLException{
      /*  System.out.println("toplam sayılar");
        System.out.println(homePage.getNumberOfArticles());
        System.out.println(homePage.getNumberAuthors());
        System.out.println(homePage.getNumberOfImages()); */
        Assert.assertEquals(homePage.getNumberOfArticles(), homePage.getNumberAuthors());
        Assert.assertTrue(homePage.eachNewsHasAuthor());

    }

    @Test
    public void verifyEachLatestNewsHasImage() throws MalformedURLException{
        Assert.assertEquals(homePage.getNumberOfArticles(), homePage.getNumberOfImages());
        Assert.assertTrue(homePage.eachNewsHasImage());
    }

}