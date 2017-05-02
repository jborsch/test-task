package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class ClickingLogoLink extends BaseTest {

    @Test
    public void test() {
        driver.get("http://informator.esphere.ru");
        SearchPage searchPage = new SearchPage(driver);
        Assert.assertFalse(searchPage.clickLogoLink().isResultsDisplayed());
    }
}
