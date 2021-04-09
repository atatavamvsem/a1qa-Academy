package domain;

import org.examples.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    //private WebDriverManager webDriverManager = WebDriverManager.getInstance();
    private WebDriver driver = WebDriverManager.getInstance().getDriver();

    By locator;
    String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }


    public void click(){
        WebElement elem = driver.findElement(this.locator);
        elem.click();
    }


}
