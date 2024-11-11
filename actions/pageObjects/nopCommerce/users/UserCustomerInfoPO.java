package pageObjects.nopCommerce.users;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.users.UserCustomerInfoPageUI;

// write all log steps (methods) for all methods in UserCustomerInfoPO:


public class UserCustomerInfoPO extends UserSideBarPO {
    WebDriver driver;

    public UserCustomerInfoPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Verify Gender Male Raido Button is selected")
    public boolean isGenderMaleRadioButtonSelected() {
        waitForElementTobeSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
        return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
    }

    @Step("Get First Name Textbox value")
    public String getFirstNameTextBoxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    @Step("Get Last Name Textbox value")
    public String getLastNameTextBoxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
    }

    @Step("Get Selected Text in Day Dropdown")
    public String getSelectedTextInDayDropdown() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
        return getSelectedItemInDropDown(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
    }

    @Step("Get Selected Text in Month Dropdown")
    public String getSelectedTextInMonthDropdown() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
        return getSelectedItemInDropDown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
    }

    @Step("Get Selected Text in Year Dropdown")
    public String getSelectedTextInYearDropdown() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
        return getSelectedItemInDropDown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
    }

    @Step("Get Email Textbox value")
    public String getEmailTextBoxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

    @Step("Get Company Textbox value")
    public String getCompanyTextBoxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX, "value");
    }


}
