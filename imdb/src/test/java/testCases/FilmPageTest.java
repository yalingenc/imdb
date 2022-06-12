package testCases;

import common.SetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FilmPage;

public class FilmPageTest extends SetUp {

    FilmPage filmPage;
    public FilmPageTest(){
        super();
    }

    @BeforeClass
    public void sourcePage(){
        filmPage = new FilmPage();
    }

    @Test(priority = 1)
    public void value() {
        filmPage.click(filmPage.imdbLogo);
        //filmPage.getValue(filmPage.director);
    }

    @Test(priority = 2)
    @Parameters("filmName")
    public void search(String fileName){
        filmPage.setText(fileName, filmPage.searchBox);
    }

    @Test(priority = 3)
    @Parameters("filmName")
    public void clickSeach(String filmName){
        filmPage.clickFilm(filmName);
    }

    @Test(priority =4)
    public void checkResultsDirector(){
        Assert.assertEquals(filmPage.directorExpected, filmPage.directorActual);
    }

    @Test(priority =5)
    public void checkResultsWriter(){
        Assert.assertEquals(filmPage.writerExpected, filmPage.writerActual);
    }

    @Test(priority =6)
    public void checkResultsStars(){
        Assert.assertEquals(filmPage.starsExpected, filmPage.starsActual);
    }


    @Test(priority = 7)
    public void clickAllPhotos(){
        filmPage.click(filmPage.allPhotos);
    }


    @Test(priority = 8)
    public void verifyPhotos() throws InterruptedException {
        filmPage.searchPhotos();
    }


}
