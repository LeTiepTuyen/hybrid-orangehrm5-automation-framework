package pageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement EMAIL_TEXTBOX;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement PASSWORD_TEXTBOX;

    @FindBy(xpath = "//button[contains(@class,'login-button')]")
    private WebElement LOGIN_BUTTON;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void enterToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver, EMAIL_TEXTBOX);
        sendKeyToElement(EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver, PASSWORD_TEXTBOX);
        sendKeyToElement(PASSWORD_TEXTBOX, password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, LOGIN_BUTTON);
        clickToElement(LOGIN_BUTTON);
    }
}
