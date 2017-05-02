package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultPage {

    private WebDriver driver;

    @FindBy(className = "result")
    private List<WebElement> results;

    public ResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Проверка наличия результатов поиска на странице.
     *
     * @return true - если результатов поиска нет, false - если результаты отображаются
     */
    public boolean isEmpty() {
        return results.isEmpty();
    }

    /**
     * Проверка корректности поиска.
     *
     * @param query поисковой запрос
     * @return true - если во всех результатах содержится искомое вхождение,
     * false - если хотя бы в одном из результатов вхождение отсутствует
     */
    public boolean isSearchCorrect(String query) {
        if (results.isEmpty() || results == null) {
            return false;
        }
        for (WebElement e : results) {
            if (!e.getText().toLowerCase().contains(query.toLowerCase())) {
                return false;
            }
        }
        return true;
    }
}
