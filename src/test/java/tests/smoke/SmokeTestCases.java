package tests.smoke;

import base.DriverManager;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.actions.HomePageActions;
import utils.BaseUtils;

import java.io.IOException;
import java.util.Hashtable;

public class SmokeTestCases {

    @BeforeSuite
    public void setUp() throws IOException {
        DriverManager.initDriver();

    }
    @Test(dataProviderClass = BaseUtils.class,dataProvider = "dp")
    public void flightSearchTest(Hashtable<String,String> data)
    {
        HomePageActions.clickOnHomeBtn();
//        HomePageActions.clickOnHotels();
        HomePageActions.clickOnFlight();
        HomePageActions.bookAFlight(data.get("fromCity"),data.get("toCity"),data.get("fromDate"),data.get("toDate"),data.get("noOfAdults"),data.get("noOfChildern"));

    }


}
