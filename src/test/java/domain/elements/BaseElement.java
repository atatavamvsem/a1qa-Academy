package domain.elements;

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
        LOGGER.debug("Click button : {}", this.name);
        findElement(this).click();
    }

    public List<WebElement> findElements(){
        LOGGER.debug("Finding elements: {}", this.name);
        return driver.findElements(this.locator);
    }

    public static WebElement findElement(BaseElement element){
        LOGGER.debug("Finding element: {}", element.name);
        return driver.findElement(element.locator);
    }

    public  boolean isDisplayed(){
        LOGGER.debug("Check is element displayed: {}", this.name);
        return findElements().size() > 0;
    }

}
