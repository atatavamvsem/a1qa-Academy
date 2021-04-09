package ru.steamPowered;

import domain.MainPage;
import domain.SearchPage;
import org.examples.ResourcesProperties;
import org.examples.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class SteamTest {

    private static MainPage mainPage = new MainPage();
    private static SearchPage searchPage;
    private WebDriverManager webDriverManager = WebDriverManager.getInstance();
    private WebDriver driver = webDriverManager.getDriver();

    @BeforeTest
    public void setUp() {
        //driver = webDriverManager.choseBrowser();
        searchPage = new SearchPage(driver);
        driver.get(ResourcesProperties.getConfProperty("loginPage"));
    }

    @Test
    public void firstTest() {

        Assert.assertTrue("it's not main page",mainPage.isDisplayed(mainPage.labelMainPage));
        mainPage.inputTextSearch(ResourcesProperties.getDataProperty("gameName"));
        mainPage.clickSearchBtn();

        Assert.assertTrue(!searchPage.elementSearchPage.isEmpty());
        Assert.assertTrue(!searchPage.allRecords.isEmpty());

        searchPage.viewSortType();
        searchPage.sortByPriceAsc();



        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(ResourcesProperties.getConfProperty("waitLoadingPageSeconds")));
        wait.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id='search_result_container']"), "style", ""));

        /*((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(searchPage.record));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> table1 = driver.findElements(By.xpath("//div[contains(@class,'search_price_discount')]"));*/

        Assert.assertTrue(checkSortPriceAsc(searchPage.listPrices));
    }

    private boolean checkSortPriceAsc(List<WebElement> listPrices) {
        int minPrice = Integer.valueOf(listPrices.get(0).getAttribute("data-price-final"));
        for (WebElement el : listPrices) {
            int checkPrice = Integer.valueOf(el.getAttribute("data-price-final"));
            if (minPrice <= checkPrice) {
                minPrice = checkPrice;
            } else return false;
        }
        return true;
    }

    @AfterTest
    public void closeUp() {
        driver.quit();
        System.out.println("The close_up process is completed");
    }

}
