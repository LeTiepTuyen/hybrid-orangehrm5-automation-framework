package com.nopcommerce.common;

import commons.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.users.*;

import java.util.Set;

public class Login extends BaseTest {

    public static Set<Cookie> nopCommerceCookies;
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
    @BeforeTest
    public void beforeTest(String browserName) {


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


        // Register:
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


        //Login:
        homePage = registerPage.clickToLogoutLink();

        loginPage = homePage.openHomePage();

        homePage = loginPage.loginToSystem(emailAddress, password);

        verifyTrue(homePage.isMyAccountLinkDisplayed());


        // Get cookie:
        nopCommerceCookies = homePage.getAllCookies(driver);
//        closeBrowserDriver();

        closeBrowserDriver();
    }


}
