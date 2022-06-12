package common;

import base.TestBase;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SetUp extends TestBase {


    public SetUp(){
        super();
    }


    @BeforeSuite
    public void dataSetup(){
        initialization();
    }


    @AfterSuite
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
