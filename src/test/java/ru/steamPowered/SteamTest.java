package ru.steamPowered;

import domain.forms.MainPage;
import domain.forms.SearchPage;
import org.junit.Assert;
import org.testng.annotations.Test;


public class SteamTest extends BaseTest {

    private MainPage mainPage = new MainPage();
    private SearchPage searchPage = new SearchPage();

    @Test
    public void firstTest() {

        Assert.assertTrue("it's not main page", mainPage.isDisplayed());

        mainPage.inputTextSearch();
        mainPage.clickSearchBtn();

        Assert.assertTrue("it's not search page", searchPage.isDisplayed());
        Assert.assertTrue(searchPage.checkResultSearch());

        searchPage.viewSortType();
        searchPage.sortByPriceAsc();

        Assert.assertTrue("wrong sorting", searchPage.checkSortPriceAsc());
    }
}
