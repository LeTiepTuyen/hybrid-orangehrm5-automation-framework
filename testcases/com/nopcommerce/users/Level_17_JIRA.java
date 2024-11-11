package com.nopcommerce.users;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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

@Feature("User Feature")
public class Level_17_JIRA extends BaseTest {

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

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void User_01_Register(Method method) {

        registerPage = homePage.openRegisterPage();


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

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed!!!");

    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void User_02_Login(Method method) {

        homePage = registerPage.clickToLogoutLink();

        loginPage = homePage.openHomePage();

        homePage = loginPage.loginToSystem(emailAddress, password);

        verifyTrue(homePage.isMyAccountLinkDisplayed());


    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void User_03_MyAccount(Method method) {

        customerInfoPage = homePage.openCustomerInfoPage();

        verifyTrue(customerInfoPage.isGenderMaleRadioButtonSelected());

        Assert.assertEquals(customerInfoPage.getFirstNameTextBoxValue(), "Hello");

        verifyEquals(customerInfoPage.getLastNameTextBoxValue(), lastName);

        verifyEquals(customerInfoPage.getSelectedTextInDayDropdown(), day);

        verifyEquals(customerInfoPage.getSelectedTextInMonthDropdown(), month);

        verifyEquals(customerInfoPage.getSelectedTextInYearDropdown(), year);

        verifyEquals(customerInfoPage.getEmailTextBoxValue(), emailAddress);

        verifyEquals(customerInfoPage.getCompanyTextBoxValue(), companyName);


    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void User_04_Swich_Page_With_Switch_Case(Method method) {


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
