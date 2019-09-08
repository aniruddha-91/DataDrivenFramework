package pages.locators;

import base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageLocators {
    //elements for hotel booking
    @FindBy(how = How.ID, using = "primary-header-home")
    public WebElement homeTab;
    @FindBy(how = How.ID, using = "tab-flight-tab-hp")
    public WebElement flightBtn;
    @FindBy(how = How.ID, using = "tab-hotel-tab-hp")
    public WebElement hotelsBtn;
    @FindBy(how = How.XPATH, using = "//button[@type='button' and @id='tab-package-tab-hp']")
    public WebElement flightPlusHotelsTab;
    @FindBy(how = How.ID, using = "tab-car-tab-hp")
    public WebElement carHireTab;
    @FindBy(how = How.ID, using = "tab-activity-tab-hp")
    public WebElement holidayActivitiesTab;
    @FindBy(how = How.NAME, using = "destination")
    public WebElement goingToTxt;
    @FindBy(how = How.ID, using = "hotel-checkin-hp-hotel")
    public WebElement checkInTxt;
    @FindBy(how = How.ID, using = "hotel-checkout-hp-hotel")
    public WebElement checkOutTxt;
    @FindBy(how = How.XPATH, using = "//button[@type='button' and @data-control='menu' and @data-gcw-component='gcw-traveler-amount-select']")
    public WebElement travellersField;
    @FindBy(how = How.XPATH, using = "//button[@type='button' and @class='uitk-step-input-button uitk-step-input-plus']/following::button[2]/child::span[@class='uitk-icon']")
    public WebElement childrenOption;
    @FindBy(how = How.XPATH, using = "//select[@type='select' and @class='gcw-storeable gcw-toggles-field-by-value gcw-child-age-select']")
    public WebElement childAgeDropDown;
    @FindBy(how = How.XPATH, using = "//button[@type='button' and @class='close btn-text']")
    public WebElement closeBtn;
    @FindBy(how = How.ID, using = "hotel-add-flight-checkbox-hp-hotel")
    public WebElement addFlightCheckbox;
    @FindBy(how = How.XPATH, using = "//button[@type='submit' and @data-gcw-change-submit-text='Search']")
    public WebElement searchBtn;

// Elements for flight booking
    @FindBy(how = How.ID, using = "flight-origin-hp-flight")
    public WebElement fromTxt;
    @FindBy(how = How.ID, using = "flight-destination-hp-flight")
    public WebElement toTxt;
    @FindBy(how = How.ID, using = "flight-departing-hp-flight")
    public WebElement departureDate;
    @FindBy(how = How.ID, using = "flight-returning-hp-flight")
    public WebElement returnDate;
    @FindBy(how = How.XPATH, using = "//*[@id='gcw-flights-form-hp-flight']/div[8]/label/button")
    public WebElement flightSearchBtn;



}
