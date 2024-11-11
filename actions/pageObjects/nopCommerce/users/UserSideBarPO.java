package pageObjects.nopCommerce.users;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageUIs.nopCommerce.users.UserSideBarUI;

// write all log steps (methods) for all methods in UserSideBarPO:
public class UserSideBarPO extends BasePage {

    WebDriver driver;

    public UserSideBarPO(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Open Address Page")
    public UserAddressPO openAddressPage() {
        waitForElementClickable(driver, UserSideBarUI.ADDRESS_LINK);
        clickToElement(driver, UserSideBarUI.ADDRESS_LINK);
        return PageGeneratorManager.getUserAddressPage(driver);
    }

    @Step("Open Reward Point Page")
    public UserRewardPointPO openRewardPointPage() {
        waitForElementClickable(driver, UserSideBarUI.REWARD_POINT_LINK);
        clickToElement(driver, UserSideBarUI.REWARD_POINT_LINK);
        return PageGeneratorManager.getUserRewardPointPage(driver);
    }

    @Step("Open Customer Info Page")
    public UserCustomerInfoPO openCustomerInfoPage() {
        waitForElementClickable(driver, UserSideBarUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, UserSideBarUI.CUSTOMER_INFO_LINK);
        return PageGeneratorManager.getUserCustomerInfoPage(driver);
    }


    @Step("Open Order Page")
    public UserOrderPO openOrderPage() {
        waitForElementClickable(driver, UserSideBarUI.ORDER_LINK);
        clickToElement(driver, UserSideBarUI.ORDER_LINK);
        return PageGeneratorManager.getUserOrderPage(driver);
    }

    @Step("Open Side Bar Page by Name: {0}")
    public UserSideBarPO openSideBarPageByName(String pageName) {
        waitForElementClickable(driver, UserSideBarUI.DYNAMIC_PAGE_LINK_BY_NAME, pageName);
        clickToElement(driver, UserSideBarUI.DYNAMIC_PAGE_LINK_BY_NAME, pageName);

        switch (pageName) {
            case "addresses":
                return PageGeneratorManager.getUserAddressPage(driver);
            case "order":
                return PageGeneratorManager.getUserOrderPage(driver);
            case "info":
                return PageGeneratorManager.getUserCustomerInfoPage(driver);
            case "rewardpoints":
                return PageGeneratorManager.getUserRewardPointPage(driver);
            default:
                return null;
        }
    }

    @Step("Open Side Bar Page by Name: {0}")
    public void openSideBarPageByNames(String pageName) {
        waitForElementClickable(driver, UserSideBarUI.DYNAMIC_PAGE_LINK_BY_NAME, pageName);
        clickToElement(driver, UserSideBarUI.DYNAMIC_PAGE_LINK_BY_NAME, pageName);
    }
}
