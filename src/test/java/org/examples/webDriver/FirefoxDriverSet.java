package org.examples.webDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverSet implements WebDriverInterface {
    public WebDriver setUp(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
