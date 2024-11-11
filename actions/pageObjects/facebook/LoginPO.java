package pageObjects.facebook;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPO extends BasePage {
    WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToCreateNewAccountButton(WebDriver driver, String locator) {
        waitForElementClickable(driver, locator);
        clickToElement(driver, locator);
        isElementDisplayed(driver, locator);
    }

}
