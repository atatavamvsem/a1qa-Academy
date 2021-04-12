package domain.forms;

import domain.elements.Button;
import domain.elements.TextField;
import org.examples.ResourcesProperties;
import org.openqa.selenium.By;

public class MainPage extends BaseForm{

    public MainPage() {
        super(idMainPage, "idMainPage");
    }

    private static Button idMainPage = new Button(By.xpath("(//div[@class='home_page_content']//a)[1]"), "idMainPage");

    private static TextField inputSearchTerm = new TextField(By.xpath("//input[@id='store_nav_search_term']"), "inputSearchMainPage");

    private static Button buttonSearch = new Button(By.xpath("//a[@id='store_search_link']//img"), "buttonSearchMainPage");

    public void clickSearchBtn(){
        buttonSearch.click();
    }

    public void inputTextSearch(){
        inputSearchTerm.sendText(ResourcesProperties.getDataProperty("gameName"));
    }

}
