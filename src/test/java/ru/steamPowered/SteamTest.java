package ru.steamPowered;

import domain.MainPage;
import domain.SearchPage;
import org.examples.ResourcesProperties;
import org.examples.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SteamTest {

    private MainPage mainPage = new MainPage();
    private SearchPage searchPage = new SearchPage();
    private WebDriverManager webDriverManager = WebDriverManager.getInstance();
    private WebDriver driver = webDriverManager.getDriver();

    @BeforeTest
    public void setUp() {
        driver.get(ResourcesProperties.getConfProperty("loginPage"));
    }

    @Test
    public void firstTest() {

        Assert.assertTrue("it's not main page",mainPage.isDisplayed());
        mainPage.inputTextSearch();
        mainPage.clickSearchBtn();

        Assert.assertTrue("it's not search page", searchPage.isDisplayed());
        Assert.assertTrue(searchPage.checkResultSearch());

        searchPage.viewSortType();
        searchPage.sortByPriceAsc();

        Assert.assertTrue("wrong sorting",searchPage.checkSortPriceAsc());
    }



    @AfterTest
    public void closeUp() {
        driver.quit();
        System.out.println("The close_up process is completed");
    }

}
