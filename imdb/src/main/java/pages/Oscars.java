package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Oscars extends TestBase {

    public Oscars (){
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[span]//*[text()='1929']")
    public WebElement clickOscars;

    @FindBy(xpath = "//div[a]//*[text()='The Circus']")
    public WebElement clickFilm;

    public void click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

}
