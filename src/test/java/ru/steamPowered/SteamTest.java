package ru.steamPowered;

import domain.MainPage;
import domain.SearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.examples.ConfProperties;
import org.examples.ServiceConfig;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;


public class SteamTest {

    public static MainPage mainPage;
    public static SearchPage searchPage;
    private WebDriver driver;
    public ServiceConfig serviceConfig = new ServiceConfig();

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = serviceConfig.choiseBrowser(ConfProperties.getProperty("browser"));
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void firstTest() {

        Assert.assertTrue(mainPage.allDivs.contains(mainPage.divMainPage));

        mainPage.inputSearchTerm.sendKeys(ConfProperties.getProperty("gamename"));
        mainPage.clickSearchBtn();

        Assert.assertTrue(!searchPage.elementSearchPage.isEmpty());
        Assert.assertTrue(!searchPage.allRecords.isEmpty());

        searchPage.viewSortType();
        searchPage.sortByPriceAsc();

        driver.navigate().refresh();

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
