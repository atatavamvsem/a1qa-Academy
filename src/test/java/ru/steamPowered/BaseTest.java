package ru.steamPowered;

import org.examples.ResourcesProperties;
import org.examples.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
    private WebDriver driver = WebDriverManager.getInstance().getDriver();

    @BeforeSuite
    public void setUp() {
        LOGGER.debug("Start testing");
        driver.get(ResourcesProperties.getConfProperty("loginPage"));
    }

    @AfterTest
    public void closeUp() {
        driver.close();
        driver.quit();
        LOGGER.debug("The close_up process is completed");
    }

}
