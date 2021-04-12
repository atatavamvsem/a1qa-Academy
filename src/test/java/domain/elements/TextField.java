package domain.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextField extends BaseElement {
    private static final Logger LOGGER = LoggerFactory.getLogger(TextField.class);

    public TextField(By locator, String name) {
        super(locator, name);
    }

    public void sendText(String text) {
        LOGGER.debug("Sending text: {}", text);
        findElement(this).sendKeys(text);
    }

}
