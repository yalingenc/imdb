package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends TestBase {

    public HomePage (){
        PageFactory.initElements(driver,this);
    }



    @FindBy(id = "imdbHeader-navDrawerOpen--desktop")
    public WebElement clickMenu;

    @FindBy(xpath = "//span[label/span='Awards & Events']//*[text()='Oscars']")
    public WebElement clickOscars;

    public void click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }



}
