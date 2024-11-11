package pageUIs.orangehrm.pim.employee;

public class PersonalDetailsPUI {
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div//input";
    public static final String AVATAR = "css=img.employee-image";

    public static final String PERSONAL_DETAILS_SAVE_BUTTON = "Xpath=//h6[text()='Personal Details']//following-sibling::form//button[@type='submit']";
    public static final String ATTACHMENT_SAVE_BUTTON = "Xpath=//h6[text()='Add Attachment']//following-sibling::form//button[@type='submit']";
    public static final String ATTACHMENT_ADD_BUTTON = "xpath=//h6[text()='Attachments']//following-sibling::button";


    public static final String SAVE_BUTTON_AT_PROFILE_PICTURE_CONTAINER = "xpath=//h6[text()='Change Profile Picture']//following-sibling::form//button[contains(string(),'Save')]";
    public static final String DYNAMIC_TOAST_SUCCESS_NOTIFICATION = "xpath=//div[contains(@class,'oxd-toast-content')]//p[contains(@class,'oxd-text--toast-message') and text()='%s']";


    public static final String DRIVER_LICENSE_NUMBER_TEXTBOX = "xpath=//label[text()=concat('Driver', \"'\", 's License Number')]/parent::div/following-sibling::div//input";
    public static final String LICENSE_EXPIRY_DATE_DATE_PICKER = "xpath=//label[contains(string(),'License Expiry Date')]/parent::div/following-sibling::div//input";
    public static final String DATE_OF_BIRTH_DATE_PICKER = "xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";
    public static final String NATIONALITY_DROP_DOWN = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String MARITAL_STATUS_DROP_DOWN = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String DROP_DOWN_OPTIONS = "xpath=//div[@role='listbox']/div[@role='option']";
    public static final String GENDER_RADIO_BUTTON = "xpath=//label[contains(string(),'%s')]//span[contains(@class,'oxd-radio-input')]";


    public static final String DYNAMIC_TEXTBOX_BY_LABEL = "xpath=//label[contains(string(),'%s')]/parent::div/following-sibling::div//input";
    public static final String DYNAMIC_DATE_PICKER_BY_LABEL = "xpath=//label[contains(string(),'%s')]/parent::div/following-sibling::div//input";
    public static final String DYNAMIC_DROPDOWN_BY_LABEL = "xpath=//label[contains(string(),'%s')]/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String GENDER_MALE_RADIO_BUTTON = "xpath=//label[contains(string(),'Male')]//span";
    public static final String GENDER_FEMALE_RADIO_BUTTON = "xpath=//label[contains(string(),'Male')]//span";
}
