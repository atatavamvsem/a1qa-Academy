package org.examples;

import org.examples.webDriver.ChromeDriverSet;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ServiceConfig {
    public WebDriver choiseBrowser(String browser) {

        if(browser.equals("chrome")){
            ChromeDriverSet chromeDriverSet = new ChromeDriverSet();
            WebDriver driver = chromeDriverSet.setUp();
            return driver;
        }

        if(browser.equals("firefox")){
            ChromeDriverSet chromeDriverSet = new ChromeDriverSet();
            WebDriver driver = chromeDriverSet.setUp();
            return driver;
        }
        throw new NoSuchElementException("not found browser");
    }
}
