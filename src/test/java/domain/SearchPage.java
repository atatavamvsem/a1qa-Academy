package domain;

import org.examples.ResourcesProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BaseForm {

    public SearchPage() {
        super(idSearchPage, "idMainPage");
    }

    private static BaseElement searchResult = new BaseElement(By.xpath("//div[contains(@id,'search_resultsRows')]//a"), "searchResult");

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
        return searchResult.findElements().size() > Integer.valueOf(ResourcesProperties.getDataProperty("numberGame"));
    }

    public boolean checkSortPriceAsc() {
        this.waitBeforeCheck();
        return checkSortPriceAsc(listPrices.findElements());
    }



    private boolean checkSortPriceAsc(List<WebElement> listPrices) {
        int minPrice = Integer.valueOf(listPrices.get(0).getAttribute("data-price-final"));
        int checkPrice;
        for (WebElement el : listPrices) {
            checkPrice = Integer.valueOf(el.getAttribute("data-price-final"));
            if (minPrice <= checkPrice) {
                minPrice = checkPrice;
            } else return false;
        }
        return true;
    }
}
