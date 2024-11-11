package pageObjects.nopCommerce.users;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageUIs.nopCommerce.users.UserLoginPageUI;

// write all log steps (methods) for all methods in UserLoginPO:


public class UserLoginPO extends BasePage {

    WebDriver driver;

    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter to Email textbox with value: {0}")
    public void enterToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    @Step("Enter to Password textbox with value: {0}")
    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Click to Login button")
    public void openLoginPage() {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
    }

    @Step("Login to system with email: {0} and password: {1}")
    public UserHomePO loginToSystem(String emailAddress, String password) {
//        enterToEmailTextBox(emailAddress);
//        enterToPasswordTextBox(password);
        enterToTextBoxByID(driver, "Email", emailAddress);
        enterToTextBoxByID(driver, "Password", password);
        openLoginPage();
        return PageGeneratorManager.getUserHomePage(driver);
    }
}
