package com.facebook.cases;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.LoginPO;
import pageObjects.facebook.PageGenerator;
import pageObjects.nopCommerce.users.*;

import java.lang.reflect.Method;

@Feature("User Feature")
public class Level_18_Undisplayed extends BaseTest {

    private WebDriver driver;
    private LoginPO loginPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGenerator.getLoginPage(driver);

        loginPage.clickToCreateNewAccountButton(driver, "//a[text()='Create New Account']");
    }


    @Test
    public void TC_01_Element_Undisplayed(Method method) {
//        loginPage.enterToEmailAddressTextbox("");


    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
