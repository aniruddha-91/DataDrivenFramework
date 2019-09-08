package utils;

import base.DriverManager;

import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import pages.actions.HomePageActions;
import pages.locators.HomePageLocators;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

public class BaseUtils {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String screenshotPath;
    public static String screenshotName;
    public static ExtentTest test;
    public BaseUtils() {

    }

    public static HomePageActions homePageActions = new HomePageActions(DriverManager.getDriver());
    public static ExcelReader excelReader = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excels\\testdata.xlsx");

    public static void waitTillVisibilityOfElement(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void waitTillElementIsClickable(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitImplicitly(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public static boolean isTestRunnable(String testName, ExcelReader excel) {

        String sheetName = "test_suite";
        int rows = excel.getRowCount(sheetName);


        for (int rNum = 2; rNum <= rows; rNum++) {

            String testCase = excel.getCellData(sheetName, "TCID", rNum);

            if (testCase.equalsIgnoreCase(testName)) {

                String runmode = excel.getCellData(sheetName, "Runmode", rNum);

                if (runmode.equalsIgnoreCase("Y"))
                    return true;
                else
                    return false;
            }


        }
        return false;
    }


    public static void captureScreenshot() throws IOException {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        Date d = new Date();
        screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
        File dest = new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName);
        FileUtils.copyFile(scrFile, dest);

    }

    @DataProvider(name="dp")
    public Object[][] getData(Method method) {
        String sheetName = method.getName();
        int noOfRows = excelReader.getRowCount(sheetName);
        int noOfColumns =excelReader.getColumnCount(sheetName);

        Object[][] data=new Object[noOfRows-1][1];
        Hashtable<String,String> table = null;

        for (int rowNum = 2; rowNum <= noOfRows; rowNum++) { // 2

            table = new Hashtable<String,String>();

            for (int colNum = 0; colNum < noOfColumns; colNum++) {

                // data[0][0]
                table.put(excelReader.getCellData(sheetName, colNum, 1), excelReader.getCellData(sheetName, colNum, rowNum));
                data[rowNum - 2][0] = table;
            }

        }

        return data;

    }

    public static void pressTab(WebDriver driver)
    {
        Actions act=new Actions(driver);
        act.sendKeys(Keys.TAB);
    }

}

