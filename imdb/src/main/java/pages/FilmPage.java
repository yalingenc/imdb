package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import util.TestUtil;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class FilmPage extends TestBase {
    TestUtil testUtil = new TestUtil();
    HttpURLConnection huc = null;
    String url = "";
    int respCode = 200;

    public FilmPage (){
        PageFactory.initElements(driver,this);
    }

    public List<WebElement> directorExpected = driver.findElements(By.xpath("//*[@data-testid=\"title-pc-wide-screen\"]/ul/li[1]/div/ul/li/a"));
    public List<WebElement> writerExpected = driver.findElements(By.xpath("//*[@data-testid=\"title-pc-wide-screen\"]/ul/li[2]/div/ul/li/a"));
    public List<WebElement> starsExpected = driver.findElements(By.xpath("//*[@data-testid=\"title-pc-wide-screen\"]/ul/li[3]/div/ul/li/a"));

    public List<WebElement> directorActual = driver.findElements(By.xpath("//*[@data-testid=\"title-pc-wide-screen\"]/ul/li[1]/div/ul/li/a"));
    public List<WebElement> writerActual = driver.findElements(By.xpath("//*[@data-testid=\"title-pc-wide-screen\"]/ul/li[2]/div/ul/li/a"));
    public List<WebElement> starsActual = driver.findElements(By.xpath("//*[@data-testid=\"title-pc-wide-screen\"]/ul/li[3]/div/ul/li/a"));

    //Photo Link
    //List<WebElement> links = driver.findElements(By.tagName("a"));

    public @FindBy(id = "home_img_holder")
    WebElement imdbLogo;

    public @FindBy(xpath = "//*[@aria-label=\"Search IMDb\"]")
    WebElement searchBox;

    public @FindBy(xpath = "//*[@class=\"react-autosuggest__suggestions-list anim-enter-done\"]//*[text()='1928']")
    WebElement clickFilm;

    //*[@id="react-autowhatever-1--item-0"]//*[text() ='The Circus']

    public @FindBy(xpath = "//*[@data-testid= \"photos-title\"]")
    WebElement allPhotos;

    public void clickFilm(String film){
        WebElement element = driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1--item-0\"]//*[text() ='"+film+"']\n"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void setText(String filmName, WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(filmName);
    }


    public void searchPhotos() throws InterruptedException {
        List<WebElement> images = driver.findElements(By.xpath("//img"));

        for(int index=0;index<images.size();index++)
        {
            WebElement image= images.get(index);
            String imageURL= image.getAttribute("src");
            System.out.println("URL of Image " + (index+1) + " is: " + imageURL);
            verifyLinks(imageURL);

            //Validate image display using JavaScript executor
            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", image);
                if (imageDisplayed) {
                    System.out.println("DISPLAY - OK");
                }else {
                    System.out.println("DISPLAY - BROKEN");
                }
            }
            catch (Exception e) {
                System.out.println("Error Occured");
            }
        }
    }

    public void verifyLinks(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
                System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage() + "is a broken link");
            }

            //Fetching and Printing the response code obtained
            else{
                System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
        }
    }

}
