package pageUIs.nopCommerce;

public class BasePageUI {

    // NopCommerce:
    public static final String ADDRESS_LINK = "xpath=//div[@class='listbox']//a[contains(@href,'addresses')]";
    public static final String ORDER_LINK = "xpath=//div[@class='listbox']//a[contains(@href,'order')]";
    public static final String REWARD_POINT_LINK = "xpath=//div[@class='listbox']//a[contains(@href,'rewardpoints')]";
    public static final String CUSTOMER_INFO_LINK = "xpath=//div[@class='listbox']//a[contains(@href,'info')]";

    //JQuery:
    public static final String UPLOAD_FILE_TYPE = "Css=input[type='file']";

    //Component:
    public static final String TEXTBOX_BY_ID = "Xpath=//input[@id='%s']";
    public static final String CHECKBOX_BY_ID = "Xpath=//input[@type='checkbox' and @id='%s']";
    public static final String RADIO_BY_ID = "Xpath=//input[@type='radio' and @id='%s']";
    public static final String BUTTON_BY_TEXT = "Xpath=//button[text()='%s']";
    public static final String DROPDOWN_BY_NAME = "Xpath=//select[@name='%s']";
    public static final String LINK_BY_TEXT = "Xpath=//a[text()='%s']";
}
