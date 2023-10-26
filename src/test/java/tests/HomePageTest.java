package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import base.BaseTest;

public class HomePageTest extends BaseTest {
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        homePage = new HomePage(driver);
    }

    @Test
    public void verifyEachLatestNewsHasAuthor(){
        Assert.assertTrue(homePage.eachNewsHasAuthor());
    }

    @Test
    public void verifyEachLatestNewsHasImage(){
        Assert.assertTrue(homePage.eachNewsHasImage());
    }
}