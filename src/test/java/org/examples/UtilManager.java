package org.examples;

import org.openqa.selenium.WebElement;

import java.util.List;

public class UtilManager {

    public static boolean checkSortPriceAsc(List<WebElement> listPrices) {
        String attribute = "data-price-final";
        int minPrice = Integer.valueOf(listPrices.get(0).getAttribute(attribute));
        int checkPrice;
        for (WebElement el : listPrices) {
            checkPrice = Integer.valueOf(el.getAttribute(attribute));
            if (minPrice <= checkPrice) {
                minPrice = checkPrice;
            } else return false;
        }
        return true;
    }
}
