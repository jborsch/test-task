package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ResultPage;
import pages.SearchPage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SearchByName extends BaseTest {

    @DataProvider
    public Object[][] getQueries() {
        return new Object[][]{
                {"222307496581", true},
                {"000000000000", false},
                {"1077764289470", true},
                {"00000000000000", false},
                {"Лыалдвлатб", false},
                {"Зелёная долина", true}
        };
    }

    @Test(dataProvider = "getQueries")
    public void test(String query, Boolean expected) {
        driver.get("http://informator.esphere.ru");
        SearchPage searchPage = new SearchPage(driver);
        ResultPage results = searchPage.search(query);
        assertThat(results.isSearchCorrect(query), is(expected));
    }
}
