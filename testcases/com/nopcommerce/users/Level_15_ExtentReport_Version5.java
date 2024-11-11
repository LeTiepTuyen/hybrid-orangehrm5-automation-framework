package com.nopcommerce.users;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.users.*;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;

public class Level_15_ExtentReport_Version5 extends BaseTest {

    private WebDriver driver;

    private UserHomePO homePage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserRegisterPO registerPage;
    private UserAddressPO addressPage;
    private UserRewardPointPO rewardPointPage;
    private UserOrderPO orderPage;
    private String firstName, lastName, emailAddress, companyName, password, day, month, year;
    private String browserName;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {


        driver = getBrowserDriver(browserName);
        this.browserName = browserName;

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
    public void User_01_Register(Method method) {
        ExtentManager.startTest(method.getName() + " - " + browserName.toUpperCase(), "User_01_Register");
        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 01: Open Register Page");
        registerPage = homePage.openRegisterPage();

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 02: Click To Male Radio");
        registerPage.clickToMaleRadio();

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 03: Enter To First Name Textbox" + firstName);
        registerPage.enterToFirstNameTextBox(firstName);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 04: Enter To Last Name Textbox" + lastName);
        registerPage.enterToLastNameTextBox(lastName);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 05: Select Day Dropdown" + day);
        registerPage.selectDayDropdown(day);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 06: Select Month Dropdown" + month);
        registerPage.selectMonthDropdown(month);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 07: Select Year Dropdown" + year);
        registerPage.selectYearDropdown(year);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 08: Enter To Email Textbox" + emailAddress);
        registerPage.enterToEmailTextBox(emailAddress);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 09: Enter To Company Textbox" + companyName);
        registerPage.enterToCompanyTextBox(companyName);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 10: Enter To Password Textbox" + password);
        registerPage.enterToPasswordTextBox(password);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 11: Enter To Confirm Password Textbox" + password);
        registerPage.enterToConfirmPasswordTextBox(password);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 12: Click To Register Button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - Step 13: Verify Register Success Message");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed!!!");

    }

    @Test
    public void User_02_Login(Method method) {
        ExtentManager.startTest(method.getName() + " - " + browserName.toUpperCase(), "User_02_Login");

        ExtentManager.getTest().log(Status.INFO, "User_02_Login - Step 01: Click To Logout Link");
        homePage = registerPage.clickToLogoutLink();

        ExtentManager.getTest().log(Status.INFO, "User_02_Login - Step 02: Open Home Page");
        loginPage = homePage.openHomePage();

        ExtentManager.getTest().log(Status.INFO, "User_02_Login - Step 03: Enter To Email Textbox" + emailAddress);
        homePage = loginPage.loginToSystem(emailAddress, password);

        ExtentManager.getTest().log(Status.INFO, "User_02_Login - Step 04: Verify My Account Link Displayed");
        verifyTrue(homePage.isMyAccountLinkDisplayed());


    }

    @Test
    public void User_03_MyAccount(Method method) {
        ExtentManager.startTest(method.getName() + " - " + browserName.toUpperCase(), "User_03_MyAccount");

        ExtentManager.getTest().log(Status.INFO, "User_03_MyAccount - Step 01: Open Customer Info Page");
        customerInfoPage = homePage.openCustomerInfoPage();

        ExtentManager.getTest().log(Status.INFO, "User_03_MyAccount - Step 02: Verify Gender Male Radio is selected");
        verifyTrue(customerInfoPage.isGenderMaleRadioButtonSelected());

        ExtentManager.getTest().log(Status.INFO, "User_03_MyAccount - Step 03: Verify First Name Textbox is displayed" + firstName);
        Assert.assertEquals(customerInfoPage.getFirstNameTextBoxValue(), "Hello");

        ExtentManager.getTest().log(Status.INFO, "User_03_MyAccount - Step 04: Verify Last Name Textbox is displayed" + lastName);
        verifyEquals(customerInfoPage.getLastNameTextBoxValue(), lastName);

        ExtentManager.getTest().log(Status.INFO, "User_03_MyAccount - Step 05: Verify Day Dropdown is displayed" + day);
        verifyEquals(customerInfoPage.getSelectedTextInDayDropdown(), day);

        ExtentManager.getTest().log(Status.INFO, "User_03_MyAccount - Step 06: Verify Month Dropdown is displayed" + month);
        verifyEquals(customerInfoPage.getSelectedTextInMonthDropdown(), month);

        ExtentManager.getTest().log(Status.INFO, "User_03_MyAccount - Step 07: Verify Year Dropdown is displayed" + year);
        verifyEquals(customerInfoPage.getSelectedTextInYearDropdown(), year);

        ExtentManager.getTest().log(Status.INFO, "User_03_MyAccount - Step 08: Verify Email Textbox is displayed" + emailAddress);
        verifyEquals(customerInfoPage.getEmailTextBoxValue(), emailAddress);

        ExtentManager.getTest().log(Status.INFO, "User_03_MyAccount - Step 09: Verify Company Textbox is displayed" + companyName);
        verifyEquals(customerInfoPage.getCompanyTextBoxValue(), companyName);


    }


    @Test
    public void User_04_Swich_Page_With_Switch_Case(Method method) {
        ExtentManager.startTest(method.getName() + " - " + browserName.toUpperCase(), "User_04_Swich_Page_With_Switch_Case");


//        Customer Info -> Address
        ExtentManager.getTest().log(Status.INFO, "User_04_Swich_Page_With_Switch_Case - Step 01: Open Address Page");
        addressPage = (UserAddressPO) customerInfoPage.openSideBarPageByName("addresses");
//        Address -> Reward Points
        ExtentManager.getTest().log(Status.INFO, "User_04_Swich_Page_With_Switch_Case - Step 02: Open Reward Point Page");
        rewardPointPage = (UserRewardPointPO) addressPage.openSideBarPageByName("rewardpoints");
//        Reward Points -> Orders
        ExtentManager.getTest().log(Status.INFO, "User_04_Swich_Page_With_Switch_Case - Step 03: Open Order Page");
        orderPage = (UserOrderPO) rewardPointPage.openSideBarPageByName("order");
//        Orders -> Address
        ExtentManager.getTest().log(Status.INFO, "User_04_Swich_Page_With_Switch_Case - Step 04: Open Address Page");
        addressPage = (UserAddressPO) orderPage.openSideBarPageByName("addresses");
//        Address -> Customer Info
        ExtentManager.getTest().log(Status.INFO, "User_04_Swich_Page_With_Switch_Case - Step 05: Open Customer Info Page");
        customerInfoPage = (UserCustomerInfoPO) addressPage.openSideBarPageByName("info");


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
