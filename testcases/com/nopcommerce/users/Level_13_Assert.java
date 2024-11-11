package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.users.*;

public class Level_13_Assert extends BaseTest {

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
        firstName = "John";
        lastName = "Wick";
        emailAddress = "johnwick" + generatedRandomNumber() + "@gmail.com";
        companyName = "John Wick Company";
        password = "123456789";
        day = "31";
        month = "January";
        year = "2002";


    }


    @Test
    public void User_01_Register() {

        registerPage = homePage.openRegisterPage();

        //Assert 01:
        Assert.assertEquals(registerPage.getRegisterPageTitle(), "REGISTER");

        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextBox(firstName);
        registerPage.enterToLastNameTextBox(lastName);
        registerPage.selectDayDropdown(day);
        registerPage.selectMonthDropdown(month);
        registerPage.selectYearDropdown(year);
        registerPage.enterToEmailTextBox(emailAddress);
        registerPage.enterToCompanyTextBox(companyName);
        registerPage.enterToPasswordTextBox(password);
        registerPage.enterToConfirmPasswordTextBox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");


    }

    @Test
    public void User_02_Login() {
        homePage = registerPage.clickToLogoutLink();
        loginPage = homePage.openHomePage();


        homePage = loginPage.loginToSystem(emailAddress, password);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());


    }

    @Test
    public void User_03_MyAccount() {
        customerInfoPage = homePage.openCustomerInfoPage();
        Assert.assertTrue(customerInfoPage.isGenderMaleRadioButtonSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextBoxValue(), firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextBoxValue(), lastName);
        Assert.assertEquals(customerInfoPage.getSelectedTextInDayDropdown(), day);
        Assert.assertEquals(customerInfoPage.getSelectedTextInMonthDropdown(), month);
        Assert.assertEquals(customerInfoPage.getSelectedTextInYearDropdown(), year);
        Assert.assertEquals(customerInfoPage.getEmailTextBoxValue(), emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyTextBoxValue(), companyName);


    }

    @Test
    public void User_04_Swich_Multiple_Pages() {
        // Customer Info -> Address
        customerInfoPage.openSideBarPageByNames("addresses");
        addressPage = PageGeneratorManager.getUserAddressPage(driver);


        // Address -> Reward Points
        addressPage.openSideBarPageByNames("rewardpoints");
        rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
        // Reward Points -> Orders
        rewardPointPage.openSideBarPageByNames("order");
        orderPage = PageGeneratorManager.getUserOrderPage(driver);
        // Orders -> Address
        orderPage.openSideBarPageByNames("addresses");
        addressPage = PageGeneratorManager.getUserAddressPage(driver);
        // Address -> Customer Info
        addressPage.openSideBarPageByNames("info");
        customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);


    }

    @Test
    public void User_05_Swich_Page_With_Switch_Case() {
        // Customer Info -> Address
        addressPage = (UserAddressPO) customerInfoPage.openSideBarPageByName("addresses");
        // Address -> Reward Points
        rewardPointPage = (UserRewardPointPO) addressPage.openSideBarPageByName("rewardpoints");
        // Reward Points -> Orders
        orderPage = (UserOrderPO) rewardPointPage.openSideBarPageByName("order");
        // Orders -> Address
        addressPage = (UserAddressPO) orderPage.openSideBarPageByName("addresses");
        // Address -> Customer Info
        customerInfoPage = (UserCustomerInfoPO) addressPage.openSideBarPageByName("info");


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
