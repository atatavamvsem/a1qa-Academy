package domain;

import org.examples.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextField extends BaseElement{
    private WebDriver driver = WebDriverManager.getInstance().getDriver();

    public TextField(By locator, String name) {
        super(locator, name);
    }

    public void sendText(String text){
        WebElement elem = driver.findElement(this.locator);
        elem.sendKeys(text);
    }

}
