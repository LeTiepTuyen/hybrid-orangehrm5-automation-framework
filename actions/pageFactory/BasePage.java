package pageFactory;

import org.openqa.selenium.*;

import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {


    public Alert waitAlertPresence(WebDriver driver) {

        //  Wait for an alert to be present and switch to it.
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
    }


    public void clickToElement(WebElement element) {
        element.click();
    }


    public void sendKeyToElement(WebElement element, String keysToSend) {
        element.clear();
        element.sendKeys(keysToSend);
    }


    public String getElementAttribute(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    public String getTextElement(WebElement element) {
        return element.getText();
    }

    public String getElementCssValue(WebElement element, String propertyName) {
        return element.getCssValue(propertyName);
    }

    public String getHexaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }


    public void checkToTheCheckBoxOrRadio(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToTheCheckBoxOrRadio(WebElement element) {
        if (element.isSelected()) {
            element.click();
        }
    }

    public Boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public Boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }

    public Boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }




    /*public void removeAttributeInDOM( WebElement element, String attributeRemove, String... restParams) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, getDynamicLocator(locator, restParams)));
    }*/


    public void waitForElementVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementInvisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOf(element));
    }


//    public void waitForElementPresence(WebDriver driver, WebElement element) {
//        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(element));
//    }


    public void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void selectItemInDropDown(WebElement element, String textItem) {
        new Select(element).selectByVisibleText(textItem);
    }

    public String getSelectedItemInDropDown(WebElement element) {
        return new Select(element).getFirstSelectedOption().getText();
    }

    public boolean waitForElementTobeSelected(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeSelected(element));
    }

    public void sleepInSeconds(long timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isPageLoadedSuccess(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
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

    /*public void uploadMultipleFiles( String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_FILE_PATH;
        String fullFileName = "";
        for (String file : fileNames) {
            fullFileName = fullFileName + filePath + file + "\n";

        }
        fullFileName = fullFileName.trim();
        getElement(driver, BasePageUI.UPLOAD_GOFILE_TYPE).sendKeys(fullFileName);
    }*/

}
