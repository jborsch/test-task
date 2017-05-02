package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    private WebDriver driver;

    private static final String HINT_TEXT = "Для поиска введите ИНН либо ОГРН. " +
            "Для поиска по названию введите часть краткого или полного наименования компании.";

    @FindBy(xpath = "//form[@name='search']//button[text()='Поиск']")
    private WebElement searchButton;

    @FindBy(xpath = "//form[@name='search']//input[2]")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='content logo']/a")
    private WebElement headLink;

    @FindBy(className = "result")
    private List<WebElement> results;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Поиск контрагентов.
     *
     * @param query поисковой запрос.
     * @return {@link ResultPage} с результатами поиска.
     */
    public ResultPage search(String query) {
        searchInput.clear();
        searchInput.sendKeys(query);
        searchButton.click();
        return new ResultPage(driver);
    }


    /**
     * Нажатие на логотип "Сфера Информатор"
     *
     * @return {@link SearchPage}
     */
    public SearchPage clickLogoLink() {
        headLink.click();
        return new SearchPage(driver);
    }

    /**
     * Проверка наличия результатов поиска
     *
     * @return true если элементы найдены, иначе false
     */
    public boolean isResultsDisplayed() {
        return results == null;
    }

    /**
     * Перемещение курсора на поле ввода
     */
    public void moveMouseToInput() {
        Actions actions = new Actions(driver);
        actions.moveToElement(searchInput).build().perform();
    }

    /**
     * Проверка отображения всплывающей подсказки
     *
     * @return true если подсказка видна, иначе false
     */
    public boolean isHintDisplayed() {
        WebElement hint = driver.findElement(By.xpath("//div[@class='search hint']"));
        return hint.isDisplayed() && hint.getText().equals(HINT_TEXT);
    }
}
