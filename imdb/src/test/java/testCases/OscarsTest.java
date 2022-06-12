package testCases;

import common.SetUp;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Oscars;

public class OscarsTest extends SetUp {

    Oscars oscars;
    public OscarsTest(){
        super();
    }

    @BeforeClass
    public void sourcePage(){
        oscars = new Oscars();
    }

    @Test(priority = 1)
    public void click1929() {
        oscars.click(oscars.clickOscars);
    }

    @Test(priority = 2)
    public void clickFilm() {
        oscars.click(oscars.clickFilm);
    }
}
