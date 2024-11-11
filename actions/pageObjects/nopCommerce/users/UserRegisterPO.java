package pageObjects.nopCommerce.users;


import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageUIs.nopCommerce.users.UserRegisterPageUI;


// write all log steps (methods) for all methods in UserRegisterPO:

public class UserRegisterPO extends BasePage {
    WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Click to Male radio button")
    public void clickToMaleRadio() {
        waitForElementClickable(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
        checkToTheCheckBoxOrRadio(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
    }

    @Step("Enter to First Name textbox with value: {0}")
    public void enterToFirstNameTextBox(String firstName) {
        waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    @Step("Enter to Last Name textbox with value: {0}")
    public void enterToLastNameTextBox(String lastName) {
        waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    @Step("Select Day dropdown with value: {0}")
    public void selectDayDropdown(String day) {
        waitForElementClickable(driver, UserRegisterPageUI.DAY_DROPDOWN);
        selectItemInDropDown(driver, UserRegisterPageUI.DAY_DROPDOWN, day);
    }

    @Step("Select Month dropdown with value: {0}")
    public void selectMonthDropdown(String month) {
        waitForElementClickable(driver, UserRegisterPageUI.MONTH_DROPDOWN);
        selectItemInDropDown(driver, UserRegisterPageUI.MONTH_DROPDOWN, month);
    }

    @Step("Select Year dropdown with value: {0}")
    public void selectYearDropdown(String year) {
        waitForElementClickable(driver, UserRegisterPageUI.YEAR_DROPDOWN);
        selectItemInDropDown(driver, UserRegisterPageUI.YEAR_DROPDOWN, year);
    }

    @Step("Enter to Email textbox with value: {0}")
    public void enterToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    @Step("Enter to Company textbox with value: {0}")
    public void enterToCompanyTextBox(String companyName) {
        waitForElementVisible(driver, UserRegisterPageUI.COMPANY_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX, companyName);
    }


    @Step("Enter to Password textbox with value: {0}")
    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Enter to Confirm Password textbox with value: {0}")
    public void enterToConfirmPasswordTextBox(String password) {
        waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    @Step("Click to Register button")
    public UserHomePO clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    @Step("Click to Logout link")
    public UserHomePO clickToLogoutLink() {
        waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    @Step("Get Register Success Message")
    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getTextElement(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    @Step("Get Register Page Title")
    public String getRegisterPageTitle() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_PAGE_TITLE);
        return getTextElement(driver, UserRegisterPageUI.REGISTER_PAGE_TITLE);
    }
}
