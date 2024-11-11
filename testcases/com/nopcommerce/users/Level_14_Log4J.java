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

public class Level_14_Log4J extends BaseTest {

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
        log.info("User_01_Register - Step 01: Open Register Page");
        registerPage = homePage.openRegisterPage();

        log.info("User_01_Register - Step 02: Click To Male Radio");
        registerPage.clickToMaleRadio();

        log.info("User_01_Register - Step 03: Enter To First Name Textbox" + firstName);
        registerPage.enterToFirstNameTextBox(firstName);

        log.info("User_01_Register - Step 04: Enter To Last Name Textbox" + lastName);
        registerPage.enterToLastNameTextBox(lastName);

        log.info("User_01_Register - Step 05: Select Day Dropdown" + day);
        registerPage.selectDayDropdown(day);

        log.info("User_01_Register - Step 06: Select Month Dropdown" + month);
        registerPage.selectMonthDropdown(month);

        log.info("User_01_Register - Step 07: Select Year Dropdown" + year);
        registerPage.selectYearDropdown(year);

        log.info("User_01_Register - Step 08: Enter To Email Textbox" + emailAddress);
        registerPage.enterToEmailTextBox(emailAddress);

        log.info("User_01_Register - Step 09: Enter To Company Textbox" + companyName);
        registerPage.enterToCompanyTextBox(companyName);

        log.info("User_01_Register - Step 10: Enter To Password Textbox" + password);
        registerPage.enterToPasswordTextBox(password);

        log.info("User_01_Register - Step 11: Enter To Confirm Password Textbox" + password);
        registerPage.enterToConfirmPasswordTextBox(password);

        log.info("User_01_Register - Step 12: Click To Register Button");
        registerPage.clickToRegisterButton();

        log.info("User_01_Register - Step 13: Verify Register Success Message");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed!!!");

    }

    @Test
    public void User_02_Login() {
        log.info("User_02_Login - Step 01: Click To Logout Link");
        homePage = registerPage.clickToLogoutLink();

        log.info("User_02_Login - Step 02: Open Home Page");
        loginPage = homePage.openHomePage();

        log.info("User_02_Login - Step 03: Enter To Email Textbox" + emailAddress);
        homePage = loginPage.loginToSystem(emailAddress, password);

        log.info("User_02_Login - Step 04: Verify My Account Link Displayed");
        verifyTrue(homePage.isMyAccountLinkDisplayed());


    }

    @Test
    public void User_03_MyAccount() {
        log.info("User_03_MyAccount - Step 01: Open Customer Info Page");
        customerInfoPage = homePage.openCustomerInfoPage();

        log.info("User_03_MyAccount - Step 02: Verify Gender Male Radio is selected");
        verifyTrue(customerInfoPage.isGenderMaleRadioButtonSelected());

        log.info("User_03_MyAccount - Step 03: Verify First Name Textbox is displayed" + firstName);
        Assert.assertEquals(customerInfoPage.getFirstNameTextBoxValue(), "Hello");

        log.info("User_03_MyAccount - Step 04: Verify Last Name Textbox is displayed" + lastName);
        verifyEquals(customerInfoPage.getLastNameTextBoxValue(), lastName);

        log.info("User_03_MyAccount - Step 05: Verify Day Dropdown is displayed" + day);
        verifyEquals(customerInfoPage.getSelectedTextInDayDropdown(), day);

        log.info("User_03_MyAccount - Step 06: Verify Month Dropdown is displayed" + month);
        verifyEquals(customerInfoPage.getSelectedTextInMonthDropdown(), month);

        log.info("User_03_MyAccount - Step 07: Verify Year Dropdown is displayed" + year);
        verifyEquals(customerInfoPage.getSelectedTextInYearDropdown(), year);

        log.info("User_03_MyAccount - Step 08: Verify Email Textbox is displayed" + emailAddress);
        verifyEquals(customerInfoPage.getEmailTextBoxValue(), emailAddress);

        log.info("User_03_MyAccount - Step 09: Verify Company Textbox is displayed" + companyName);
        verifyEquals(customerInfoPage.getCompanyTextBoxValue(), companyName);


    }

//    @Test
//    public void User_04_Swich_Multiple_Pages() {
//        // Customer Info -> Address
//
//        log.info("User_04_Swich_Multiple_Pages - Step 01: Open Address Page");
//        customerInfoPage.openSideBarPageByNames("addresses");
//        addressPage = PageGeneratorManager.getUserAddressPage(driver);
//
//
//        // Address -> Reward Points
//        addressPage.openSideBarPageByNames("rewardpoints");
//        rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
//        // Reward Points -> Orders
//        rewardPointPage.openSideBarPageByNames("order");
//        orderPage = PageGeneratorManager.getUserOrderPage(driver);
//        // Orders -> Address
//        orderPage.openSideBarPageByNames("addresses");
//        addressPage = PageGeneratorManager.getUserAddressPage(driver);
//        // Address -> Customer Info
//        addressPage.openSideBarPageByNames("info");
//        customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
//
//
//    }

    @Test
    public void User_04_Swich_Page_With_Switch_Case() {
        // Customer Info -> Address
        log.info("User_04_Swich_Page_With_Switch_Case - Step 01: Open Address Page");
        addressPage = (UserAddressPO) customerInfoPage.openSideBarPageByName("addresses");
        // Address -> Reward Points
        log.info("User_04_Swich_Page_With_Switch_Case - Step 02: Open Reward Point Page");
        rewardPointPage = (UserRewardPointPO) addressPage.openSideBarPageByName("rewardpoints");
        // Reward Points -> Orders
        log.info("User_04_Swich_Page_With_Switch_Case - Step 03: Open Order Page");
        orderPage = (UserOrderPO) rewardPointPage.openSideBarPageByName("order");
        // Orders -> Address
        log.info("User_04_Swich_Page_With_Switch_Case - Step 04: Open Address Page");
        addressPage = (UserAddressPO) orderPage.openSideBarPageByName("addresses");
        // Address -> Customer Info
        log.info("User_04_Swich_Page_With_Switch_Case - Step 05: Open Customer Info Page");
        customerInfoPage = (UserCustomerInfoPO) addressPage.openSideBarPageByName("info");


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
