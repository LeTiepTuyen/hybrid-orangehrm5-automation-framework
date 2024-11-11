package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_StaticMethod {
    BasePage basePage;
    WebDriver driver;
    private String firstName, lastName, emailAddress, companyName, password, day, month, year;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        basePage = BasePage.getBasePage();
        driver.get("http://demo.nopcommerce/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        firstName = "John";
        lastName = "Wick";
        emailAddress = "johnwick" + generatedRandomNumber() + "@gmail.com";
        companyName = "John Wick Company";
        password = "123456789";
        day = "31";
        month = "January";
        year = "2002";


    }

    private String generatedRandomNumber() {
        return new Random().nextInt(999999) + "";
    }

    @Test
    public void TC_01_Register() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.waitForElementClickable(driver, "//input[@id='gender-male']");
        basePage.clickToElement(driver, "//input[@id='gender-male']");

        basePage.sendKeyToElement(driver, "//input[@id='FirstName']", firstName);
        basePage.sendKeyToElement(driver, "//input[@id='LastName']", lastName);

        basePage.selectItemInDropDown(driver, "//select[@name='DateOfBirthDay']", day);
        basePage.selectItemInDropDown(driver, "//select[@name='DateOfBirthMonth']", month);
        basePage.selectItemInDropDown(driver, "//select[@name='DateOfBirthYear']", year);


        basePage.sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
        basePage.sendKeyToElement(driver, "//input[@id='Company']", companyName);
        basePage.sendKeyToElement(driver, "//input[@id='Password']", password);
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", password);

        basePage.waitForElementClickable(driver, "//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");


        Assert.assertEquals(basePage.getTextElement(driver, "//div[@class='result']"), "Your registration completed");

    }

    @Test
    public void TC_02_Login() {

        basePage.waitForElementClickable(driver, "//a[@class='ico-logout']");
        basePage.clickToElement(driver, "//a[@class='ico-logout']");

        basePage.waitForElementClickable(driver, "//a[@class='ico-login']");
        basePage.clickToElement(driver, "//a[@class='ico-login']");

        basePage.sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
        basePage.sendKeyToElement(driver, "//input[@id='Password']", password);

        basePage.waitForElementClickable(driver, "//button[contains(@class,'login-button')]");
        basePage.clickToElement(driver, "//button[contains(@class,'login-button')]");

        Assert.assertTrue(basePage.isElementDisplayed(driver, "//a[@class='ico-account']"));

    }

    @Test
    public void TC_03_MyAccount() {

        basePage.waitForElementClickable(driver, "//a[@class='ico-account']");
        basePage.clickToElement(driver, "//a[@class='ico-account']");

        Assert.assertTrue(basePage.isElementSelected(driver, "//input[@id='gender-male']"));
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='LastName']", "value"), lastName);
        Assert.assertEquals(basePage.getSelectedItemInDropDown(driver, "//select[@name='DateOfBirthDay']"), day);
        Assert.assertEquals(basePage.getSelectedItemInDropDown(driver, "//select[@name='DateOfBirthMonth']"), month);
        Assert.assertEquals(basePage.getSelectedItemInDropDown(driver, "//select[@name='DateOfBirthYear']"), year);
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='Email']", "value"), emailAddress);
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='Company']", "value"), companyName);


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
