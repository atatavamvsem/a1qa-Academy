package ru.steamPowered;

import domain.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.examples.ConfProperties;
import org.examples.ServiceConfig;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SteamTest {

    public static MainPage mainPage;
    private WebDriver driver;
    private String gameName = "The witcher";
    public ServiceConfig serviceConfig = new ServiceConfig();

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = serviceConfig.choiseBrowser(ConfProperties.getProperty("browser"));
        mainPage = new MainPage(driver);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void firstTest() {

        /*try {
            WebElement email = driver.findElement(By.xpath("//div[@class='home_page_content']"));
            System.out.println("it's main page");
        } catch (NoSuchElementException e) {
            System.out.println("it's not main page");
        }*/
        //List<WebElement> email = driver.findElements(By.xpath("//div"));
        //WebElement email1 = driver.findElement(By.xpath("//div[@class='home_page_content']"));
        Assert.assertTrue(mainPage.allDivs.contains(mainPage.divMainPage));
        WebElement inputSearch = driver.findElement(By.xpath("//input[@id='store_nav_search_term']"));
        inputSearch.sendKeys(gameName);
        WebElement buttonSearch = driver.findElement(By.xpath("//a[@id='store_search_link']//img"));
        buttonSearch.click();
        WebElement table = driver.findElement(By.xpath("//div[@id='search_resultsRows']"));
    }

    @AfterTest
    public void closeUp() {
        driver.quit();
        System.out.println("The close_up process is completed");
    }

}
