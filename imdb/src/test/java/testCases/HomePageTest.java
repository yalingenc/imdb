package testCases;

import common.SetUp;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends SetUp {

    HomePage homePage;
    public HomePageTest(){
        super();
    }

    @BeforeClass
    public void sourcePage(){
        homePage = new HomePage();
    }

    @Test(priority = 1)
    @Parameters("filmName")
    public void clickMenu(String filmName) {
        System.out.print(filmName);
        homePage.click(homePage.clickMenu);
    }

    @Test(priority = 2)
    public void clickOscars() {
        homePage.click(homePage.clickOscars);
    }

}
