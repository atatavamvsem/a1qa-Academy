package domain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора все дивы на странице
     */
    @FindBy(xpath = "//div")
    public List<WebElement> allDivs;

    /**
     * определение локатора div главной страницы
     */
    @FindBy(xpath = "//div[@class='home_page_content']")
    public WebElement divMainPage;

    /**
     * определение локатора поля ввода текста для поиска
     */
    @FindBy(xpath = "//input[@id='store_nav_search_term']")
    private WebElement inputSearchTerm;


}
