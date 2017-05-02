package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class HintDisplay extends BaseTest {

    @Test
    public void test() {
        driver.get("http://informator.esphere.ru");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.moveMouseToInput();
        Assert.assertTrue(searchPage.isHintDisplayed());
    }
}
