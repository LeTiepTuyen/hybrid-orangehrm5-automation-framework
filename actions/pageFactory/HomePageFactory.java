package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory extends BasePage {
    WebDriver driver;
    @FindBy(xpath = "//a[@class='ico-register']")
    private WebElement REGISTER_LINK;

    @FindBy(xpath = "//a[@class='ico-login']")
    private WebElement LOGIN_LINK;

    @FindBy(xpath = "//a[@class='ico-account']")
    private WebElement MY_ACCOUNT_LINK;

    public HomePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickToRegisterLink() {
        waitForElementClickable(driver, REGISTER_LINK);
        clickToElement(REGISTER_LINK);

    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, LOGIN_LINK);
        clickToElement(LOGIN_LINK);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, MY_ACCOUNT_LINK);
        return isElementDisplayed(MY_ACCOUNT_LINK);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver, MY_ACCOUNT_LINK);
        clickToElement(MY_ACCOUNT_LINK);
    }
}
