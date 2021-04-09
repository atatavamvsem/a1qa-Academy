package domain;

import org.examples.WebDriverManager;
import org.openqa.selenium.WebDriver;

public abstract class BaseForm {
    private static WebDriver driver = WebDriverManager.getInstance().getDriver();
    private BaseElement element;
    private String name;

    public BaseForm(BaseElement element, String name, WebDriver driver) {
        this.element = element;
        this.name = name;
        this.driver = driver;
    }

    protected BaseForm() {
    }

    public boolean isDisplayed(BaseElement element){
        Boolean isPresent = driver.findElements(element.locator).size() > 0;
        return isPresent;
    }
}
