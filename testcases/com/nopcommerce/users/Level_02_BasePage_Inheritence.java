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

public class Level_02_BasePage_Inheritence extends BasePage {

    WebDriver driver;
    private String firstName, lastName, emailAddress, companyName, password, day, month, year;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

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
        waitForElementClickable(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//a[@class='ico-register']");

        waitForElementClickable(driver, "//input[@id='gender-male']");
        clickToElement(driver, "//input[@id='gender-male']");

        sendKeyToElement(driver, "//input[@id='FirstName']", firstName);
        sendKeyToElement(driver, "//input[@id='LastName']", lastName);

        selectItemInDropDown(driver, "//select[@name='DateOfBirthDay']", day);
        selectItemInDropDown(driver, "//select[@name='DateOfBirthMonth']", month);
        selectItemInDropDown(driver, "//select[@name='DateOfBirthYear']", year);


        sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
        sendKeyToElement(driver, "//input[@id='Company']", companyName);
        sendKeyToElement(driver, "//input[@id='Password']", password);
        sendKeyToElement(driver, "//input[@id='ConfirmPassword']", password);

        waitForElementClickable(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");


        Assert.assertEquals(getTextElement(driver, "//div[@class='result']"), "Your registration completed");

    }

    @Test
    public void TC_02_Login() {

        waitForElementClickable(driver, "//a[@class='ico-logout']");
        clickToElement(driver, "//a[@class='ico-logout']");

        waitForElementClickable(driver, "//a[@class='ico-login']");
        clickToElement(driver, "//a[@class='ico-login']");

        sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
        sendKeyToElement(driver, "//input[@id='Password']", password);

        waitForElementClickable(driver, "//button[contains(@class,'login-button')]");
        clickToElement(driver, "//button[contains(@class,'login-button')]");

        Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));

    }

    @Test
    public void TC_03_MyAccount() {

        waitForElementClickable(driver, "//a[@class='ico-account']");
        clickToElement(driver, "//a[@class='ico-account']");

        Assert.assertTrue(isElementSelected(driver, "//input[@id='gender-male']"));
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='LastName']", "value"), lastName);
        Assert.assertEquals(getSelectedItemInDropDown(driver, "//select[@name='DateOfBirthDay']"), day);
        Assert.assertEquals(getSelectedItemInDropDown(driver, "//select[@name='DateOfBirthMonth']"), month);
        Assert.assertEquals(getSelectedItemInDropDown(driver, "//select[@name='DateOfBirthYear']"), year);
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='Email']", "value"), emailAddress);
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='Company']", "value"), companyName);


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
