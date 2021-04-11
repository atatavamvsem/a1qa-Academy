package domain;

import org.examples.ResourcesProperties;
import org.examples.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseForm {
    private static WebDriver driver = WebDriverManager.getInstance().getDriver();
    private BaseElement element;
    private String name;

    public BaseForm(BaseElement element, String name) {
        this.element = element;
        this.name = name;
    }

    public boolean isDisplayed(){
        return element.isDisplayed();
    }

    public void waitBeforeCheck(){
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(ResourcesProperties.getConfProperty("waitLoadingPageSeconds")));
        wait.until(ExpectedConditions.attributeToBe(this.element.locator, "style", ""));
    }
}
