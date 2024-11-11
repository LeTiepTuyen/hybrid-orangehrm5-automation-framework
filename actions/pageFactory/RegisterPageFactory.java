package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageFactory extends BasePage {
    WebDriver driver;
    @FindBy(xpath = "//input[@id='gender-male']")
    private WebElement GENDER_MALE_RADIO;
    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement FIRST_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement LAST_NAME_TEXTBOX;
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    private WebElement DAY_DROPDOWN;
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    private WebElement MONTH_DROPDOWN;
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    private WebElement YEAR_DROPDOWN;
    @FindBy(xpath = "//input[@id='Email']")
    private WebElement EMAIL_TEXTBOX;
    @FindBy(xpath = "//input[@id='Company']")
    private WebElement COMPANY_TEXTBOX;
    @FindBy(xpath = "//input[@id='Password']")
    private WebElement PASSWORD_TEXTBOX;
    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    private WebElement CONFIRM_PASSWORD_TEXTBOX;
    @FindBy(xpath = "//button[@id='register-button']")
    private WebElement REGISTER_BUTTON;
    @FindBy(xpath = "//div[@class='result']")
    private WebElement REGISTER_SUCCESS_MESSAGE;
    @FindBy(xpath = "//a[@class='ico-logout']")
    private WebElement LOGOUT_LINK;

    public RegisterPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickToMaleRadio() {
        waitForElementClickable(driver, GENDER_MALE_RADIO);
        checkToTheCheckBoxOrRadio(GENDER_MALE_RADIO);
    }

    public void enterToFirstNameTextBox(String firstName) {
        waitForElementVisible(driver, FIRST_NAME_TEXTBOX);
        sendKeyToElement(FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextBox(String lastName) {
        waitForElementVisible(driver, LAST_NAME_TEXTBOX);
        sendKeyToElement(LAST_NAME_TEXTBOX, lastName);
    }

    public void selectDayDropdown(String day) {
        waitForElementClickable(driver, DAY_DROPDOWN);
        selectItemInDropDown(DAY_DROPDOWN, day);
    }

    public void selectMonthDropdown(String month) {
        waitForElementClickable(driver, MONTH_DROPDOWN);
        selectItemInDropDown(MONTH_DROPDOWN, month);
    }

    public void selectYearDropdown(String year) {
        waitForElementClickable(driver, YEAR_DROPDOWN);
        selectItemInDropDown(YEAR_DROPDOWN, year);
    }

    public void enterToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver, EMAIL_TEXTBOX);
        sendKeyToElement(EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToCompanyTextBox(String companyName) {
        waitForElementVisible(driver, COMPANY_TEXTBOX);
        sendKeyToElement(COMPANY_TEXTBOX, companyName);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver, PASSWORD_TEXTBOX);
        sendKeyToElement(PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextBox(String password) {
        waitForElementVisible(driver, CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, REGISTER_BUTTON);
        clickToElement(REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessage() {
        return getTextElement(REGISTER_SUCCESS_MESSAGE);
    }

    public void clickToLogoutLink() {
        waitForElementClickable(driver, LOGOUT_LINK);
        clickToElement(LOGOUT_LINK);
    }
}
