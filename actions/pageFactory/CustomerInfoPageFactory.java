package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPageFactory extends BasePage {
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

    public CustomerInfoPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isGenderMaleRadioButtonSelected() {

        return waitForElementTobeSelected(driver, GENDER_MALE_RADIO);
    }

    public String getFirstNameTextBoxValue() {
        waitForElementVisible(driver, FIRST_NAME_TEXTBOX);
        return getElementAttribute(FIRST_NAME_TEXTBOX, "value");
    }

    public String getLastNameTextBoxValue() {
        waitForElementVisible(driver, LAST_NAME_TEXTBOX);
        return getElementAttribute(LAST_NAME_TEXTBOX, "value");
    }

    public String getSelectedTextInDayDropdown() {
        waitForElementVisible(driver, DAY_DROPDOWN);
        return getSelectedItemInDropDown(DAY_DROPDOWN);
    }

    public String getSelectedTextInMonthDropdown() {
        waitForElementVisible(driver, MONTH_DROPDOWN);
        return getSelectedItemInDropDown(MONTH_DROPDOWN);
    }

    public String getSelectedTextInYearDropdown() {
        waitForElementVisible(driver, YEAR_DROPDOWN);
        return getSelectedItemInDropDown(YEAR_DROPDOWN);
    }

    public String getEmailTextBoxValue() {
        waitForElementVisible(driver, EMAIL_TEXTBOX);
        return getElementAttribute(EMAIL_TEXTBOX, "value");
    }

    public String getCompanyTextBoxValue() {
        waitForElementVisible(driver, COMPANY_TEXTBOX);
        return getElementAttribute(COMPANY_TEXTBOX, "value");
    }
}
