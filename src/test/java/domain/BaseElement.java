package domain;

import org.examples.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BaseElement {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseElement.class);
    private static WebDriver driver = WebDriverManager.getInstance().getDriver();
    public By locator;
    private String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }


    public void click(){
        LOGGER.debug("Click button : ", this.name);
        WebElement elem = driver.findElement(this.locator);
        elem.click();
    }

    public List<WebElement> findElements(){
        return driver.findElements(this.locator);
    }

    public static WebElement findElement(BaseElement element){
        return driver.findElement(element.locator);
    }

    public  boolean isDisplayed(){
        return findElements().size() > 0;
    }


}
