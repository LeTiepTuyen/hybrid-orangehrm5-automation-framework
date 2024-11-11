package com.nopcommerce.users;

import com.nopcommerce.common.Login;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.users.*;

public class Level_20_Share_State_Close_Browser extends BaseTest {

    private WebDriver driver;

    private UserHomePO homePage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserRegisterPO registerPage;
    private UserAddressPO addressPage;
    private UserRewardPointPO rewardPointPage;
    private UserOrderPO orderPage;
    private String firstName, lastName, emailAddress, companyName, password, day, month, year;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {


        driver = getBrowserDriver(browserName);


        homePage = PageGeneratorManager.getUserHomePage(driver);

        // Data for Register:
        firstName = "John";
        lastName = "Wick";
        emailAddress = "johnwick" + generatedRandomNumber() + "@gmail.com";
        companyName = "John Wick Company";
        password = "123456789";
        day = "31";
        month = "January";
        year = "2002";

        homePage.setAllCookies(driver, Login.nopCommerceCookies);
        homePage.refreshCurrentPage(driver);
        Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_01_MyAccountInfo() {
        customerInfoPage = homePage.openCustomerInfoPage();
        customerInfoPage.sleepInSeconds(3);
    }

    @Test
    public void User_02_Payment() {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
