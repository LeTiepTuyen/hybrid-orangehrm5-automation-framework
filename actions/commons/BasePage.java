package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.users.*;
import pageUIs.nopCommerce.BasePageUI;
import pageUIs.nopCommerce.users.UserSideBarUI;
import pageUIs.orangehrm.BasePUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    public static BasePage getBasePage() {
        return new BasePage();
    }

    private By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public void clickAndHoldToElement(WebDriver driver, String locator) {
        new Actions(driver).clickAndHold(getElement(driver, locator)).perform();
    }

    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitAlertPresence(WebDriver driver) {

        //  Wait for an alert to be present and switch to it.
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        waitAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver) {
        waitAlertPresence(driver).dismiss();
    }

    public void sendkeyToAlert(WebDriver driver, String keysToSend) {
        waitAlertPresence(driver).sendKeys(keysToSend);
    }

    public String getAlertText(WebDriver driver) {
        return waitAlertPresence(driver).getText();
    }

    public void swithToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            driver.switchTo().window(runWindow);
            String currentWinTitle = driver.getTitle();
            if (currentWinTitle.equals(title)) {
                break;
            }
        }

    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    protected WebElement getElement(WebDriver driver, String locator) {
        try {
            return driver.findElement(getByLocator(locator));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected List<WebElement> getListElements(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    protected List<WebElement> getListElements(WebDriver driver, String locator, String... dynamicValues) {
        return driver.findElements(getByLocator(formatLocator(locator, dynamicValues)));
    }

    protected Integer getListElementsNumber(WebDriver driver, String locator, String... dynamicValues) {
        return driver.findElements(getByLocator(formatLocator(locator, dynamicValues))).size();
    }


    private By getByLocator(String prefixLocator) {
        if (prefixLocator == null || prefixLocator.isEmpty()) {
            throw new IllegalArgumentException("Locator type cannot be null or empty");
        }

        String locator = prefixLocator.toLowerCase();

        // Xử lý các loại locator dựa vào prefix
        if (locator.startsWith("xpath=")) {
            return By.xpath(prefixLocator.substring(6));
        } else if (locator.startsWith("css=")) {
            return By.cssSelector(prefixLocator.substring(4));
        } else if (locator.startsWith("id=")) {
            return By.id(prefixLocator.substring(3));
        } else if (locator.startsWith("name=")) {
            return By.name(prefixLocator.substring(5));
        } else if (locator.startsWith("class=")) {
            return By.className(prefixLocator.substring(6));
        } else if (locator.startsWith("tagname=")) {
            return By.tagName(prefixLocator.substring(8));
        } else {
            throw new IllegalArgumentException("The By locator is not valid: " + prefixLocator);
        }

    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public String formatLocator(String locator, String... dynamicValues) {
        return String.format(locator, (Object[]) dynamicValues);
    }

    public void clickToElement(WebDriver driver, String locator, String... dynamicValues) {
        getElement(driver, formatLocator(locator, dynamicValues)).click();
    }

    public void clickToElement(WebElement element) {
        element.click();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String keysToSend) {

        // hàm getElement(driver, locator).clear(); khi gặp một the input bị ẩn thì sẽ gây ra lỗi
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(keysToSend);
    }

    public void sendKeyToElement(WebDriver driver, String locator, String valueToSendkey, String... dynamicValues) {
        getElement(driver, formatLocator(locator, dynamicValues)).clear();
        getElement(driver, formatLocator(locator, dynamicValues)).sendKeys(valueToSendkey);
    }

    public void selectItemInDropDown(WebDriver driver, String locator, String textItem) {
        new Select(getElement(driver, locator)).selectByVisibleText(textItem);
    }

    public void selectItemInDropDown(WebDriver driver, String locator, String textItem, String... dynamicValues) {
        new Select(getElement(driver, formatLocator(locator, dynamicValues))).selectByVisibleText(textItem);
    }

    public String getSelectedItemInDropDown(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public String getSelectedItemInDropDown(WebDriver driver, String locator, String... dynamicValues) {
        return new Select(getElement(driver, formatLocator(locator, dynamicValues))).getFirstSelectedOption().getText();
    }

    public Boolean isDropdownIsMultiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        clickToElement(driver, parentLocator);
        sleepInSeconds(2);
//

        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));
        sleepInSeconds(2);
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSeconds(1);

                item.click();
                break;
            }
        }
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
        return getElement(driver, locator).getAttribute(attributeName);
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName, String... dynamicValues) {
        return getElement(driver, formatLocator(locator, dynamicValues)).getAttribute(attributeName);
    }

    public String getTextElement(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getTextElement(WebDriver driver, String locator, String... dynamicValues) {
        return getElement(driver, formatLocator(locator, dynamicValues)).getText();
    }

    public String getElementCssValue(WebDriver driver, String locator, String propertyName) {
        return getElement(driver, locator).getCssValue(propertyName);
    }


    public String getElementCssValue(WebDriver driver, String locator, String propertyName, String... dynamicValues) {
        return getElement(driver, formatLocator(locator, dynamicValues)).getCssValue(propertyName);
    }

    public String getDOMPropertyValue(WebDriver driver, String locator, String propertyName) {
        return getElement(driver, locator).getDomProperty(propertyName);
    }

    public String getDOMPropertyValue(WebDriver driver, String locator, String propertyName, String... dynamicValues) {
        return getElement(driver, formatLocator(locator, dynamicValues)).getDomProperty(propertyName);
    }

    public String getHexaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getListElementsSize(WebDriver driver, String locator) {
        return getListElements(driver, locator).size();
    }

    public void checkToTheCheckBoxOrRadio(WebDriver driver, String locator) {
        if (!getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    public void checkToTheCheckBoxOrRadio(WebDriver driver, String locator, String... dynamicValues) {
        if (!getElement(driver, formatLocator(locator, dynamicValues)).isSelected()) {
            getElement(driver, formatLocator(locator, dynamicValues)).click();
        }
    }

    public void uncheckToTheCheckBoxOrRadio(WebDriver driver, String locator) {
        if (getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    public void uncheckToTheCheckBoxOrRadio(WebDriver driver, String locator, String... dynamicValues) {
        if (getElement(driver, formatLocator(locator, dynamicValues)).isSelected()) {
            getElement(driver, formatLocator(locator, dynamicValues)).click();
        }
    }

    public Boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public Boolean isElementDisplayed(WebDriver driver, String locator, String... dynamicValues) {
        return getElement(driver, formatLocator(locator, dynamicValues)).isDisplayed();
    }

    public Boolean isElementUnDisplayed(WebDriver driver, String locator, String... dynamicValues) {
        overideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = getListElements(driver, formatLocator(locator, dynamicValues));
        overideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
        if (elements.isEmpty()) {
            return true;
        } else if (!elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    private void overideGlobalTimeout(WebDriver driver, long timeInSecond) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSecond));
    }

    public Boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public Boolean isElementSelected(WebDriver driver, String locator, String... dynamicValues) {
        return getElement(driver, formatLocator(locator, dynamicValues)).isSelected();
    }

    public Boolean isElementEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    public Boolean isElementEnabled(WebDriver driver, String locator, String... dynamicValues) {
        return getElement(driver, formatLocator(locator, dynamicValues)).isEnabled();
    }

    public void switchToIframe(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver, locator));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void hoverMouseToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();
    }


    public void releaseLeftMouse(WebDriver driver, String locator) {
        new Actions(driver).release().perform();

    }

    public void rightClickToElement(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getElement(driver, locator)).perform();
    }

    public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
    }

    public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
        new Actions(driver).sendKeys(getElement(driver, locator), key).perform();
    }

    public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... dynamicValues) {
        new Actions(driver).sendKeys(getElement(driver, formatLocator(locator, dynamicValues)), key).perform();
    }

    public void scrollToElement(WebDriver driver, String locator) {
        new Actions(driver).scrollToElement(getElement(driver, locator)).perform();
    }

    public void scrollToElement(WebDriver driver, String locator, String... dynamicValues) {
        new Actions(driver).scrollToElement(getElement(driver, formatLocator(locator, dynamicValues))).perform();
    }


    public Object executeForBrowser(WebDriver driver, String javaScript) {
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

    public String getInnerText(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(WebDriver driver, String textExpected) {
        String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomViewPortByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void scrollToTopViewPortByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
        ((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
        sleepInSeconds(3);
    }

    public void highlightElement(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInSeconds(3);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator, String... dynamicValues) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, formatLocator(locator, dynamicValues)));

    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public void sendKeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(driver, locator));
    }

    public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_PATH;
        StringBuilder fullFileName = new StringBuilder();
        for (String file : fileNames) {
            fullFileName.append(filePath).append(file).append("\n");
        }

        // Không nên dùng hàm sendKeyToElement() viêt sa
        getElement(driver, BasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName.toString().trim());

    }

    /*public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove, String... restParams) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, getDynamicLocator(locator, restParams)));
    }*/

    public void waitForElementAttributeToBe(WebDriver driver, String locator, String attributeName, String attributeValue, String... dynamicValues) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.attributeToBe(getElement(driver, formatLocator(locator, dynamicValues)), attributeName, attributeValue));
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... dynamicValues) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(formatLocator(locator, dynamicValues))));
    }

    public void waitForAllElementVisible(WebDriver driver, String locator, String... dynamicValues) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(formatLocator(locator, dynamicValues))));
    }


    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }


    public void waitForElementInvisible(WebDriver driver, String locator, String... dynamicValues) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(formatLocator(locator, dynamicValues))));
    }

    public Boolean waitForListElementInvisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver, locator)));
    }


    public void waitForElementTobeSelected(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }

    public void waitForElementTobeSelected(WebDriver driver, String locator, String... dynamicValues) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeSelected(getByLocator(formatLocator(locator, dynamicValues))));
    }

    public void waitForElementPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementPresence(WebDriver driver, String locator, String... dynamicValues) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(getByLocator(formatLocator(locator, dynamicValues))));
    }


    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... dynamicValues) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(formatLocator(locator, dynamicValues))));
    }


    public void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));
    }


    public void sleepInSeconds(long timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isPageLoadedSuccess(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    /*public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_FILE_PATH;
        String fullFileName = "";
        for (String file : fileNames) {
            fullFileName = fullFileName + filePath + file + "\n";

        }
        fullFileName = fullFileName.trim();
        getElement(driver, BasePageUI.UPLOAD_GOFILE_TYPE).sendKeys(fullFileName);
    }*/


    public UserAddressPO openAddressPage(WebDriver driver) {
        waitForElementClickable(driver, UserSideBarUI.ADDRESS_LINK);
        clickToElement(driver, UserSideBarUI.ADDRESS_LINK);
        return PageGeneratorManager.getUserAddressPage(driver);
    }

    public UserRewardPointPO openRewardPointPage(WebDriver driver) {
        waitForElementClickable(driver, UserSideBarUI.REWARD_POINT_LINK);
        clickToElement(driver, UserSideBarUI.REWARD_POINT_LINK);
        return PageGeneratorManager.getUserRewardPointPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage(WebDriver driver) {
        waitForElementClickable(driver, UserSideBarUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, UserSideBarUI.CUSTOMER_INFO_LINK);
        return PageGeneratorManager.getUserCustomerInfoPage(driver);
    }


    public UserOrderPO openOrderPage(WebDriver driver) {
        waitForElementClickable(driver, UserSideBarUI.ORDER_LINK);
        clickToElement(driver, UserSideBarUI.ORDER_LINK);
        return PageGeneratorManager.getUserOrderPage(driver);
    }

    public void openAdminSite(WebDriver driver, String adminUrl) {
        openPageUrl(driver, adminUrl);
    }

    public void openUserSite(WebDriver driver, String userUrl) {
        openPageUrl(driver, userUrl);
    }

    public void enterToTextBoxByID(WebDriver driver, String textBoxID, String value) {
        waitForElementVisible(driver, BasePageUI.TEXTBOX_BY_ID, textBoxID);
        sendKeyToElement(driver, BasePageUI.TEXTBOX_BY_ID, value, textBoxID);
    }

    public void clickToButtonByText(WebDriver driver, String buttonByText) {
        waitForElementClickable(driver, BasePageUI.BUTTON_BY_TEXT, buttonByText);
        clickToElement(driver, BasePageUI.BUTTON_BY_TEXT, buttonByText);
    }

    public void selectDropDownByName(WebDriver driver, String dropdownByName, String value) {
        waitForElementClickable(driver, BasePageUI.DROPDOWN_BY_NAME, dropdownByName);
        selectItemInDropDown(driver, BasePageUI.DROPDOWN_BY_NAME, value, dropdownByName);
    }

    public void clickToLinkByText(WebDriver driver, String linkByText) {
        waitForElementClickable(driver, BasePageUI.LINK_BY_TEXT, linkByText);
        clickToElement(driver, BasePageUI.LINK_BY_TEXT, linkByText);

    }

    public Set<Cookie> getAllCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }


    public void setAllCookies(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }

        sleepInSeconds(3);
    }

    public void clickToRadioByID(WebDriver driver, String radioByID) {
        waitForElementClickable(driver, BasePageUI.RADIO_BY_ID, radioByID);
        checkToTheCheckBoxOrRadio(driver, BasePageUI.RADIO_BY_ID, radioByID);
    }

    public void clickToCheckBoxByID(WebDriver driver, String checkBoxByID) {
        waitForElementClickable(driver, BasePageUI.CHECKBOX_BY_ID, checkBoxByID);
        checkToTheCheckBoxOrRadio(driver, BasePageUI.CHECKBOX_BY_ID, checkBoxByID);
    }

    public String getTextBoxValueByID(WebDriver driver, String textBoxID) {
        waitForElementVisible(driver, BasePageUI.TEXTBOX_BY_ID, textBoxID);
        return getElementAttribute(driver, BasePageUI.TEXTBOX_BY_ID, "value", textBoxID);
    }

    public String getSelectedTextInDropdownByName(WebDriver driver, String dropdownByName) {
        waitForElementVisible(driver, BasePageUI.DROPDOWN_BY_NAME, dropdownByName);
        return getSelectedItemInDropDown(driver, BasePageUI.DROPDOWN_BY_NAME, dropdownByName);
    }

    public Boolean isRadioByIDSelected(WebDriver driver, String radioByID) {
        waitForElementTobeSelected(driver, BasePageUI.RADIO_BY_ID, radioByID);
        return isElementSelected(driver, BasePageUI.RADIO_BY_ID, radioByID);
    }

    public Boolean isCheckBoxByIDSelected(WebDriver driver, String checkBoxByID) {
        waitForElementTobeSelected(driver, BasePageUI.CHECKBOX_BY_ID, checkBoxByID);
        return isElementSelected(driver, BasePageUI.CHECKBOX_BY_ID, checkBoxByID);
    }

    public boolean waitForAllLoadingIconInvisible(WebDriver driver) {
        return waitForListElementInvisible(driver, BasePUI.LOADING_ICON);
    }
}
