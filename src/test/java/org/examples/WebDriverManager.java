package org.examples;

import org.examples.webDriver.ChromeDriverSet;
import org.examples.webDriver.FirefoxDriverSet;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class WebDriverManager {
    private ChromeDriverSet chromeDriverSet = new ChromeDriverSet();
    private FirefoxDriverSet firefoxDriverSet = new FirefoxDriverSet();
    private WebDriver driver;
    private static WebDriverManager instance;

    public static WebDriverManager getInstance() {
        if (instance == null) {
            instance = new WebDriverManager();
        }
        return instance;
    }

    public WebDriver choseBrowser(String browser) {

        if(browser.equals("chrome")){
            driver = chromeDriverSet.setUp();
            return driver;
        }

        if(browser.equals("firefox")){
            driver = firefoxDriverSet.setUp();
            return driver;
        }

        throw new NoSuchElementException("not found browser");
    }

    public WebDriver getDriver(){
        if (driver != null) {
            return driver;
        }else {
            return choseBrowser(ResourcesProperties.getConfProperty("browser"));
        }
    }
}
