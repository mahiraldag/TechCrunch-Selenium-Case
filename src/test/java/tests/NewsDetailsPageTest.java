package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.NewsDetailsPage;
import utils.BaseUtil;

public class NewsDetailsPageTest extends BaseUtil {
    private NewsDetailsPage newsDetailsPage;

    @BeforeClass
    public void setUp() {
        super.setup();
        driver.get("https://techcrunch.com/");
        newsDetailsPage = new NewsDetailsPage(driver);
    }

    @Test
    public void verifyNewsTitleAndBrowserTitleAreSame() {
        Assert.assertTrue(newsDetailsPage.getBrowserTitle().contains(newsDetailsPage.getFirstArticleTitle()));
        //  driver.navigate().back();
    }

    @Test
    public void verifyNewsHasLinksWithinContent() {
        newsDetailsPage.verifyCopyLinkButton();
        //  driver.navigate().back();
    }
}
