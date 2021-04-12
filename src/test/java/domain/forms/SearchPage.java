package domain.forms;

import domain.elements.BaseElement;
import domain.elements.Button;
import domain.elements.TextField;
import org.examples.ResourcesProperties;
import org.examples.UtilManager;
import org.openqa.selenium.By;

public class SearchPage extends BaseForm {

    public SearchPage() {
        super(idSearchPage, "idMainPage");
    }

    private static BaseElement listSearchResult = new BaseElement(By.xpath("//div[contains(@id,'search_resultsRows')]//a"), "listSearchResult");

    private static BaseElement listPrices = new BaseElement(By.xpath("//div[contains(@class,'search_price_discount')]"), "listPrices");

    private static TextField idSearchPage = new TextField(By.xpath("//div[@id='search_result_container']"), "idSearchPage");

    private static Button sortTrigger = new Button(By.xpath("//a[@id='sort_by_trigger']"), "sortTrigger");

    private static Button sortByPriceAsc = new Button(By.xpath("//a[@id='Price_ASC']"), "sortByPriceAsc");

    public void viewSortType() {
        sortTrigger.click();
    }

    public void sortByPriceAsc() {
        sortByPriceAsc.click();
    }

    public boolean checkResultSearch() {
        return listSearchResult.findElements().size() > Integer.valueOf(ResourcesProperties.getDataProperty("numberGame"));
    }

    public boolean checkSortPriceAsc() {
        this.waitBeforeCheck();
        return UtilManager.checkSortPriceAsc(listPrices.findElements());
    }




}
