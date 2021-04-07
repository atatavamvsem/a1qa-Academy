package domain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    public WebDriver driver;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора результатов поиска
     */
    @FindBy(xpath = "//div[contains(@id,'search_resultsRows')]//a")
    public List<WebElement> allRecords;

    /**
     * определение локатора результатов поиска
     */
    @FindBy(xpath = "//div[contains(@id,'search_resultsRows')]//a[1]")
    public WebElement record;

    /**
     * определение локатора с ценами записей
     */
    @FindBy(xpath = "//div[contains(@class,'search_price_discount')]")
    public List<WebElement> listPrices;

    /**
     * определение локатора элемента страницы поиска
     */
    @FindBy(xpath = "//body[contains(@class,'search_page')]")
    public List<WebElement> elementSearchPage;

    /**
     * определение локатора тригера сортировки
     */
    @FindBy(xpath = "//a[@id='sort_by_trigger']")
    public WebElement sortTrigger;

    /**
     * определение локатора типа сортировки по возрастанию цены
     */
    @FindBy(xpath = "//a[@id='Price_ASC']")
    public WebElement sortByPriceAsc;

    public void viewSortType(){
        sortTrigger.click();
    }

    public void sortByPriceAsc() {
        sortByPriceAsc.click();
    }
}
