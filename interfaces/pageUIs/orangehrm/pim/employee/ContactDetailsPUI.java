package pageUIs.orangehrm.pim.employee;

public class ContactDetailsPUI {
    public static final String STREET1_TEXTBOX = "xpath=//label[text()='Street 1']/parent::div/following-sibling::div/input";
    public static final String CITY_TEXTBOX = "xpath=//label[text()='City']/parent::div/following-sibling::div/input";
    public static final String DYNAMIC_CONTACT_DETAILS_TEXTBOX_BY_LABEL = "xpath=//label[text()='%s']/parent::div/following-sibling::div/input";
    public static final String COUNTRY_DROPDOWN = "xpath=//label[text()='Country']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String DROP_DOWN_OPTIONS = "xpath=//div[@role='listbox']/div[@role='option']";
    public static final String SAVE_BUTTON_AT_CONTACT_DETAILS_CONTAINER = "xpath=//h6[text()='Contact Details']//following-sibling::form//button[@type='submit']";
    ;
}
