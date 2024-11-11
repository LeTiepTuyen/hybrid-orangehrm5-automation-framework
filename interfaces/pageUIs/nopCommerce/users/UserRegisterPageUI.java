package pageUIs.nopCommerce.users;

public class UserRegisterPageUI {
    public static final String GENDER_MALE_RADIO = "XPath=//input[@id='gender-male']";
    public static final String FIRST_NAME_TEXTBOX = "CSS=input#FirstName";
    public static final String LAST_NAME_TEXTBOX = "id=LastName";
    public static final String DAY_DROPDOWN = "Xpath=//select[@name='DateOfBirthDay']";
    public static final String MONTH_DROPDOWN = "XPath=//select[@name='DateOfBirthMonth']";
    public static final String YEAR_DROPDOWN = "xpath=//select[@name='DateOfBirthYear']";

    public static final String EMAIL_TEXTBOX = "id=Email";
    public static final String COMPANY_TEXTBOX = "ID=Company";
    public static final String PASSWORD_TEXTBOX = "id=Password";
    public static final String CONFIRM_PASSWORD_TEXTBOX = "css=#ConfirmPassword";
    public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";
    public static final String REGISTER_SUCCESS_MESSAGE = "xpath=//div[@class='result']";
    public static final String LOGOUT_LINK = "css=a[class='ico-logout']";
    public static final String REGISTER_PAGE_TITLE = "css=div.page-title>h1";
}
