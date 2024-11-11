package com.jquery;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.PageGenerator;

import java.util.List;

public class Level_11_Data_Table extends BaseTest {

    private WebDriver driver;

    private HomePO homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {


        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);

    }


    //    @Test
    public void Table_01_Paging() {
        homePage.openPageByNumber("15");
        Assert.assertTrue(homePage.isPageActiveByNumber("15"));


        homePage.openPageByNumber("5");
        Assert.assertTrue(homePage.isPageActiveByNumber("5"));

        homePage.openPageByNumber("24");
        Assert.assertTrue(homePage.isPageActiveByNumber("24"));

    }

    //    @Test
    public void Table_02_Search() {
        homePage.enterToTextBoxByColumnName("Country", "Argentina");
        homePage.sleepInSeconds(3);
        Assert.assertTrue(homePage.isRowValueDisplayed("338282", "Argentina", "349238", "687522"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextBoxByColumnName("Males", "803");
        homePage.sleepInSeconds(3);
        Assert.assertTrue(homePage.isRowValueDisplayed("777", "Antigua and Barbuda", "803", "1580"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextBoxByColumnName("Females", "159");
        homePage.sleepInSeconds(3);
        Assert.assertTrue(homePage.isRowValueDisplayed("15999", "Armenia", "16456", "32487"));
        homePage.refreshCurrentPage(driver);
    }

    //    @Test
    public void Table_03_Edit_Delete() {
        //Delete:
//        homePage.enterToTextBoxByColumnName("Country", "Argentina");
//        homePage.sleepInSeconds(3);
//        homePage.deleteRowByCountryName("Argentina");
//        homePage.refreshCurrentPage(driver);
//
//
//        homePage.enterToTextBoxByColumnName("Country", "Aruba");
//        homePage.sleepInSeconds(3);
//        homePage.deleteRowByCountryName("Aruba");
//        homePage.refreshCurrentPage(driver);


        //Edit:
        homePage.enterToTextBoxByColumnName("Country", "Aruba");
        homePage.sleepInSeconds(3);
        homePage.editRowByCountryName("Aruba");
        homePage.editFieldValueByLabelName("758", "males");
        Assert.assertEquals(homePage.getCellValueByCountryNameAndColumnName("Aruba", "males"), "758");
        homePage.refreshCurrentPage(driver);
    }

    //    @Test
    public void Table_04_Action_By_Index() {
        homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");

        homePage.clickToLoadDataButton();

//        homePage.enterToTextBoxByIndex("3", "Company", "Michel");
//
//        homePage.enterToTextBoxByIndex("4", "Contact Person", "Lukas");
//
//        homePage.enterToTextBoxByIndex("5", "Order Placed", "123232");
//
//        homePage.selectToDropdownByIndex("6", "Country", "Hong Kong");
//        homePage.selectToDropdownByIndex("1", "Country", "Taiwan");
//
//        homePage.checkToCheckboxByIndex("6", "NPO?", true);
//        homePage.checkToCheckboxByIndex("5", "NPO?", false);
//
        homePage.clickToIconByIndex("8", "Move Up");
        homePage.clickToIconByIndex("7", "Move Down");
        homePage.clickToIconByIndex("6", "Remove");
        homePage.clickToIconByIndex("3", "Insert");

    }

    //    @Test
    public void Table_05_Get_All_Value_In_Column() {
        List<String> allValueInColumn = homePage.getAllValueInColumn("Total");
        for (String value : allValueInColumn) {
            System.out.println(value);
        }
    }

    @Test
    public void Table_06_Get_All_Page_Value_In_Column() {
        List<String> allValueInColumn = homePage.getAllPageValueInColumn("Total");
        for (String value : allValueInColumn) {
            System.out.println(value);
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
