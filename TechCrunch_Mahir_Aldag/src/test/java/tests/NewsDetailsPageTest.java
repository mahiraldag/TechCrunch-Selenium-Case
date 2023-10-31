package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NewsDetailsPage;
import base.BaseTest;

public class NewsDetailsPageTest extends BaseTest {
    private NewsDetailsPage newsDetailsPage;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        newsDetailsPage = new NewsDetailsPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void verifyNewsTitleAndBrowserTitleAreSame() {
        homePage.goToNewsDetails();
        Assert.assertTrue(newsDetailsPage.getBrowserTitle().contains(newsDetailsPage.getFirstArticleTitle()));
        // Assert.assertEquals(newsDetailsPage.getBrowserTitle(), newsDetailsPage.getFirstArticleTitle());
    }

    @Test
    public void verifyLinksWithinNews() {
        homePage.goToNewsDetails();
        Assert.assertTrue(newsDetailsPage.verifyLinksWithinNewsContent());
    }
}
