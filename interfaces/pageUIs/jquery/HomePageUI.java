package pageUIs.jquery;

import org.openqa.selenium.WebElement;

public class HomePageUI {
    public static final String DYNAMIC_PAGE_LINK = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
    public static final String ALL_PAGE_LINK = "xpath=//a[contains(@class,'qgrd-pagination-page-link')]";
    public static final String DYNAMIC_TEXTBOX_BY_COLUMN_NAME = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
    public static final String DYNAMIC_ROW_DATA = "xpath=//td[@data-key='females' and text()='%s']" +
            "/following-sibling::td[@data-key='country' and text()='%s']" +
            "/following-sibling::td[@data-key='males' and text()='%s']" +
            "/following-sibling::td[@data-key='total' and text()='%s']";
    public static final String DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME = "xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'remove')]";
    public static final String DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME = "xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'edit')]";
    public static final String DYNAMIC_TEXTBOX_BY_LABEL_NAME = "xpath=//label[text()='%s']/following-sibling::input";
    public static final String OKE_BUTTON = "css=input.qgrd-modal-submit";

    public static final String DYNAMIC_CELL_BY_COUNTRY_AND_COLUMN_NAME = "xpath=//td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='%s']";
    public static final String LOAD_DATA_BUTTON = "css=button#load";
    public static final String DYNAMIC_PRECEDING_SIBLINGS_NUMBER = "xpath=//div[text()='%s']//ancestor::th/preceding-sibling::th";
    public static final String DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]/input";
    public static final String DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//select";
    public static final String DYNAMIC_CHECKBOX_OR_RADIO_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]//td[%s]//input[@type='checkbox']";
    public static final String DYNAMIC_ICON_BY_ROW_AND_ACTION = "xpath=//tr[%s]//td[8]//button[contains(@title,'%s')]";
    public static final String DYNAMIC_ALL_VALUE_BY_COLUMN_NAME = "xpath=//tr/td[%s]";
    public static final String DYNAMIC_FILE_NAME_LOADED_SUCCESS = "Xpath=//td//p[text()='%s']";
    public static final String START_UPLOAD_BUTTON = "xpath=//td//button[contains(@class,'start')]";
    public static final String DYNAMIC_FILE_NAME_UPLOADED_SUCCESS = "Xpath=//td//a[text()='%s']";
}
