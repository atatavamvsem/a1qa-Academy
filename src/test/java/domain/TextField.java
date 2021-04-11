package domain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextField extends BaseElement {

    public TextField(By locator, String name) {
        super(locator, name);
    }

    public void sendText(String text) {
        WebElement elem = findElement(this);
        elem.sendKeys(text);
    }

}
