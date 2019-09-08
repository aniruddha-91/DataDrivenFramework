package pages.actions;

import base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.locators.HomePageLocators;
import utils.BaseUtils;


public class HomePageActions extends DriverManager {
    public static HomePageLocators homePageLocator;
    public static WebDriver driver;

    public HomePageActions(WebDriver driver) {
        this.driver = driver;
        this.homePageLocator = new HomePageLocators();
        PageFactory.initElements(DriverManager.getDriver(), this.homePageLocator);
    }

    public static void clickOnHomeBtn() {
        BaseUtils.waitTillElementIsClickable(driver, homePageLocator.homeTab);
        homePageLocator.homeTab.click();
    }

    public static void clickOnHotels() {
        BaseUtils.waitTillElementIsClickable(driver, homePageLocator.hotelsBtn);
        homePageLocator.hotelsBtn.click();
    }

    public static void clickOnFlight() {
        BaseUtils.waitTillElementIsClickable(driver, homePageLocator.flightBtn);
        homePageLocator.flightBtn.click();
    }

    public static void bookAFlight(String from, String to, String departing, String returning,
                            String noOfAdults, String noOfChildern) {

        homePageLocator.fromTxt.sendKeys(from);
        homePageLocator.toTxt.sendKeys(to);
        homePageLocator.departureDate.sendKeys(departing);
        BaseUtils.pressTab(driver);
        homePageLocator.returnDate.sendKeys(returning);


        homePageLocator.flightSearchBtn.click();
    }


}
