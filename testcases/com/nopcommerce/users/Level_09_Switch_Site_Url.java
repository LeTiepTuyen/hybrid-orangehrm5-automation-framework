package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.users.UserHomePO;
import pageObjects.nopCommerce.users.UserLoginPO;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.users.UserRegisterPO;
import pageObjects.nopCommerce.users.UserAddressPO;
import pageObjects.nopCommerce.users.UserCustomerInfoPO;
import pageObjects.nopCommerce.users.UserOrderPO;
import pageObjects.nopCommerce.users.UserRewardPointPO;

public class Level_09_Switch_Site_Url extends BaseTest {

    private WebDriver driver;

    private UserHomePO userHomePage;
    private UserLoginPO userLoginPage;
    private UserCustomerInfoPO userCustomerInfoPage;
    private UserRegisterPO userRegisterPage;
    private UserAddressPO userAddressPage;
    private UserRewardPointPO userRewardPointPage;
    private UserOrderPO userOrderPage;
    private String firstName, lastName, emailAddress, companyName, password, day, month, year;
    private String adminUrl;
    private String userUrl;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDashboardPO;
    private String adminEmail = "tuyentieple@gmail.com", adminPassword = "tuyentieple@gmail.com";


    @Parameters({"browser", "userUrl", "adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {
        this.adminUrl = adminUrl;
        this.userUrl = userUrl;

        driver = getBrowserDriver(browserName, this.userUrl);

        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        firstName = "John";
        lastName = "Wick";
        emailAddress = "johnwick" + generatedRandomNumber() + "@gmail.com";
        companyName = "John Wick Company";
        password = "123456789";
        day = "31";
        month = "January";
        year = "2002";

        userRegisterPage = userHomePage.openRegisterPage();

        userRegisterPage.clickToMaleRadio();
        userRegisterPage.enterToFirstNameTextBox(firstName);
        userRegisterPage.enterToLastNameTextBox(lastName);
        userRegisterPage.selectDayDropdown(day);
        userRegisterPage.selectMonthDropdown(month);
        userRegisterPage.selectYearDropdown(year);
        userRegisterPage.enterToEmailTextBox(emailAddress);
        userRegisterPage.enterToCompanyTextBox(companyName);
        userRegisterPage.enterToPasswordTextBox(password);
        userRegisterPage.enterToConfirmPasswordTextBox(password);
        userRegisterPage.clickToRegisterButton();
        Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
    }


    @Test
    public void Case_01_User_To_Admin() {
        userHomePage = userRegisterPage.clickToLogoutLink();
        userLoginPage = userHomePage.openHomePage();


        userHomePage = userLoginPage.loginToSystem(emailAddress, password);
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());


        userHomePage.openAdminSite(driver, adminUrl);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

        adminLoginPage.enterToEmailTextBox(adminEmail);
        adminLoginPage.enterToPasswordTextBox(adminPassword);
        adminDashboardPO = adminLoginPage.clickToLoginButton();
    }

    @Test
    public void Case_02_Admin_To_User() {
        adminDashboardPO.openUserSite(driver, userUrl);

        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        userCustomerInfoPage = userHomePage.openCustomerInfoPage();

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
