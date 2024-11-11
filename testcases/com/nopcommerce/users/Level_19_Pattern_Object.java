package com.nopcommerce.users;

import commons.BaseTest;
import io.qameta.allure.Feature;
import jiraConfigs.JiraCreateIssue;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.users.*;

import java.lang.reflect.Method;

public class Level_19_Pattern_Object extends BaseTest {

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
    public void User_01_Register() {


        registerPage = homePage.openRegisterPage();

        registerPage.clickToRadioByID(driver, "gender-male");

        registerPage.enterToTextBoxByID(driver, "FirstName", firstName);

        registerPage.enterToTextBoxByID(driver, "LastName", lastName);


        registerPage.selectDropDownByName(driver, "DateOfBirthDay", day);
        registerPage.selectDropDownByName(driver, "DateOfBirthMonth", month);
        registerPage.selectDropDownByName(driver, "DateOfBirthYear", year);


        registerPage.enterToTextBoxByID(driver, "Email", emailAddress);

        registerPage.enterToTextBoxByID(driver, "Company", companyName);

        registerPage.clickToCheckBoxByID(driver, "Newsletter");


        registerPage.enterToTextBoxByID(driver, "Password", password);

        registerPage.enterToTextBoxByID(driver, "ConfirmPassword", password);

        registerPage.clickToButtonByText(driver, "Register");


        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

    }

    @Test
    public void User_02_Login() {


        homePage = registerPage.clickToLogoutLink();

        loginPage = homePage.openHomePage();

        homePage = loginPage.loginToSystem(emailAddress, password);

        verifyTrue(homePage.isMyAccountLinkDisplayed());


    }

    @Test
    public void User_03_MyAccount() {

        customerInfoPage = homePage.openCustomerInfoPage();


        verifyTrue(customerInfoPage.isRadioByIDSelected(driver, "gender-male"));


        verifyEquals(customerInfoPage.getTextBoxValueByID(driver, "FirstName"), firstName);

        verifyEquals(customerInfoPage.getTextBoxValueByID(driver, "LastName"), lastName);


        verifyEquals(customerInfoPage.getSelectedTextInDropdownByName(driver, "DateOfBirthDay"), day);

        verifyEquals(customerInfoPage.getSelectedTextInDropdownByName(driver, "DateOfBirthMonth"), month);

        verifyEquals(customerInfoPage.getSelectedTextInDropdownByName(driver, "DateOfBirthYear"), year);

        verifyEquals(customerInfoPage.getTextBoxValueByID(driver, "Email"), emailAddress);

        verifyEquals(customerInfoPage.getTextBoxValueByID(driver, "Company"), companyName);


    }

    @Test
    public void User_04_Swich_Page_With_Switch_Case() {


//        Customer Info -> Address
        addressPage = (UserAddressPO) customerInfoPage.openSideBarPageByName("addresses");
//        Address -> Reward Points
        rewardPointPage = (UserRewardPointPO) addressPage.openSideBarPageByName("rewardpoints");
//        Reward Points -> Orders
        orderPage = (UserOrderPO) rewardPointPage.openSideBarPageByName("order");
//        Orders -> Address
        addressPage = (UserAddressPO) orderPage.openSideBarPageByName("addresses");
//        Address -> Customer Info
        customerInfoPage = (UserCustomerInfoPO) addressPage.openSideBarPageByName("info");


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
