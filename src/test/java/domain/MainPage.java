package domain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends BaseForm{

    public MainPage() {

    }
    /**
     * определение локатора все дивы на странице
     */
    @FindBy(xpath = "//div")
    public List<WebElement> allDivs;

    /**
     * определение локатора div главной страницы
     */

    public TextField labelMainPage = new TextField(By.xpath("//div[@class='home_page_content']//h1"), "labelMainPage");

    /**
     * определение титла главной страницы
     */
    @FindBy(xpath = "//head//title")
    public WebElement title;

    /**
     * определение локатора поля ввода текста для поиска
     */
    private TextField inputSearchTerm = new TextField(By.xpath("//input[@id='store_nav_search_term']"), "inputSearchMainPage");;

    /**
     * определение локатора кнопки поиска
     */


    private Button buttonSearch = new Button(By.xpath("//a[@id='store_search_link']//img"), "buttonSearchMainPage");




    public void clickSearchBtn(){
        buttonSearch.click();
    }

    public void inputTextSearch(String gameName){
        inputSearchTerm.sendText(gameName);
    }
}
