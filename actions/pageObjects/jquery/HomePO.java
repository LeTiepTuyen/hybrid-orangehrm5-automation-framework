package pageObjects.jquery;

import commons.BasePage;
import pageUIs.jquery.HomePageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePO extends BasePage {
    WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }


    public void openPageByNumber(String number) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGE_LINK, number);
        clickToElement(driver, HomePageUI.DYNAMIC_PAGE_LINK, number);
        sleepInSeconds(2);
    }

    public boolean isPageActiveByNumber(String number) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_PAGE_LINK, number);
        return getElementAttribute(driver, HomePageUI.DYNAMIC_PAGE_LINK, "class", number)
                .contains("active");
    }

    public void enterToTextBoxByColumnName(String columnName, String valueToSendkey) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_COLUMN_NAME, columnName);
        sendKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_COLUMN_NAME, valueToSendkey, columnName);
        pressKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_COLUMN_NAME, Keys.ENTER, columnName);
    }

    public boolean isRowValueDisplayed(String femaleValue, String countryValue, String maleValue, String totalValue) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_ROW_DATA, femaleValue, countryValue, maleValue, totalValue);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_ROW_DATA, femaleValue, countryValue, maleValue, totalValue);
    }

    public void deleteRowByCountryName(String countryName) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME, countryName);
        sleepInSeconds(2);
    }

    public void editRowByCountryName(String countryName) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME, countryName);
        sleepInSeconds(2);
    }

    public void editFieldValueByLabelName(String valueToSendkey, String labelName) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, labelName);
        sendKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, valueToSendkey, labelName);
        waitForElementClickable(driver, HomePageUI.OKE_BUTTON);
        clickToElement(driver, HomePageUI.OKE_BUTTON);
    }

    public String getCellValueByCountryNameAndColumnName(String countryName, String columnName) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_CELL_BY_COUNTRY_AND_COLUMN_NAME, countryName, columnName);
        return getTextElement(driver, HomePageUI.DYNAMIC_CELL_BY_COUNTRY_AND_COLUMN_NAME, countryName, columnName);
    }

    public void clickToLoadDataButton() {
        waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
        clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
    }

    public void enterToTextBoxByIndex(String rowIndex, String columnName, String valueToSendkey) {
        String columnIndex = String.valueOf(getListElements(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLINGS_NUMBER, columnName).size() + 1);
        sendKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX, valueToSendkey, rowIndex, columnIndex);
        sleepInSeconds(2);
    }

    public void selectToDropdownByIndex(String rowIndex, String columnName, String textItem) {
        String columnIndex = String.valueOf(getListElements(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLINGS_NUMBER, columnName).size() + 1);
        selectItemInDropDown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX, textItem, rowIndex, columnIndex);
        sleepInSeconds(2);
    }

    public void checkToCheckboxByIndex(String rowIndex, String columnName, boolean checkOrUncheck) {
        String columnIndex = String.valueOf(getListElements(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLINGS_NUMBER, columnName).size() + 1);
        if (checkOrUncheck) {
            checkToTheCheckBoxOrRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_OR_RADIO_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
        } else {
            uncheckToTheCheckBoxOrRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_OR_RADIO_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
        }


        sleepInSeconds(2);
    }

    public void clickToIconByIndex(String rowIndex, String action) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_AND_ACTION, rowIndex, action);
        clickToElement(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_AND_ACTION, rowIndex, action);
        sleepInSeconds(2);
    }

    public List<String> getAllValueInColumn(String columnName) {
        List<String> allValueInColumn = new ArrayList<String>();
        String columnIndex = String.valueOf(getListElements(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLINGS_NUMBER, columnName).size() + 1);
        waitForAllElementVisible(driver, HomePageUI.DYNAMIC_ALL_VALUE_BY_COLUMN_NAME, columnIndex);
        List<WebElement> listAllElements = getListElements(driver, HomePageUI.DYNAMIC_ALL_VALUE_BY_COLUMN_NAME, columnIndex);
        for (WebElement element : listAllElements) {
            allValueInColumn.add(element.getText());
        }
        return allValueInColumn;
    }

    public List<String> getAllPageValueInColumn(String columnName) {
        List<String> allValueInColumn = new ArrayList<String>();
        String columnIndex = String.valueOf(getListElements(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLINGS_NUMBER, columnName).size() + 1);
        waitForAllElementVisible(driver, HomePageUI.ALL_PAGE_LINK);
        List<WebElement> allPagesLink = getListElements(driver, HomePageUI.ALL_PAGE_LINK);

        for (WebElement pageLink : allPagesLink) {
            pageLink.click();
            sleepInSeconds(1);
            waitForAllElementVisible(driver, HomePageUI.DYNAMIC_ALL_VALUE_BY_COLUMN_NAME, columnIndex);
            List<WebElement> listAllElements = getListElements(driver, HomePageUI.DYNAMIC_ALL_VALUE_BY_COLUMN_NAME, columnIndex);
            for (WebElement element : listAllElements) {
                allValueInColumn.add(element.getText());
            }
        }

        return allValueInColumn;
    }

    public boolean areFilesLoadedSuccess(String... fileNames) {
        //DYNAMIC_FILE_NAME_LOADED_SUCCESS
        for (String fileName : fileNames) {
            waitForElementVisible(driver, HomePageUI.DYNAMIC_FILE_NAME_LOADED_SUCCESS, fileName);
            if (!isElementDisplayed(driver, HomePageUI.DYNAMIC_FILE_NAME_LOADED_SUCCESS, fileName)) {
                return false;
            }
        }
        return true;
    }

    public void clickToStartButton() {

        List<WebElement> startButtons = getListElements(driver, HomePageUI.START_UPLOAD_BUTTON);
        for (WebElement startButton : startButtons) {
            waitForElementClickable(driver, startButton);
            startButton.click();
            sleepInSeconds(2);
        }
    }

    public boolean areFilesUploadedSuccess(String... fileNames) {
        for (String fileName : fileNames) {
            waitForElementVisible(driver, HomePageUI.DYNAMIC_FILE_NAME_UPLOADED_SUCCESS, fileName);
            if (!isElementDisplayed(driver, HomePageUI.DYNAMIC_FILE_NAME_UPLOADED_SUCCESS, fileName)) {
                return false;
            }
        }
        return true;
    }
}
