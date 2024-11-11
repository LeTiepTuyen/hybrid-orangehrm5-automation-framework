package pageObjects.orangehrm.pim.employee;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGeneratorManager;
import pageUIs.orangehrm.pim.employee.PersonalDetailsPUI;

public class PersonalDetailsPO extends EmployeeNavigationPO {
    private WebDriver driver;

    public PersonalDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public String getEmployeeID() {
        waitForAllLoadingIconInvisible(driver);
        waitForElementVisible(driver, PersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX);
        return getDOMPropertyValue(driver, PersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public ProfilePicturePO clickToEmployeeAvatarImage() {
        waitForElementClickable(driver, PersonalDetailsPUI.AVATAR);
        clickToElement(driver, PersonalDetailsPUI.AVATAR);
        return PageGeneratorManager.getProfilePicturePage(driver);
    }

    public void uploadAvatarImage(String imageUrl) {
        uploadMultipleFiles(driver, imageUrl);
    }

    public void clickToSaveButtonAtProfilePictureContainer() {
        waitForElementClickable(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_PROFILE_PICTURE_CONTAINER);
        clickToElement(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_PROFILE_PICTURE_CONTAINER);
    }

    public boolean isSuccessMessageToasterDisplayed(String message) {
        waitForElementVisible(driver, PersonalDetailsPUI.DYNAMIC_TOAST_SUCCESS_NOTIFICATION, message);
        return isElementDisplayed(driver, PersonalDetailsPUI.DYNAMIC_TOAST_SUCCESS_NOTIFICATION, message);
        // div.oxd-toast-content>p.oxd-text--toast-message]
    }

    public Dimension getAvatarSize() {
        waitForElementVisible(driver, PersonalDetailsPUI.AVATAR);
        return getElement(driver, PersonalDetailsPUI.AVATAR).getSize();
    }

    public boolean isAvatarImageUploadedSuccess(Dimension beforeUpload) {

        Dimension afterUpload = getAvatarSize();
        // print width and height of before upload and after upload:
        System.out.println("Before upload: " + beforeUpload);
        System.out.println("After upload: " + afterUpload);

        return !beforeUpload.equals(afterUpload);
    }

    public void enterToDriverLicenseNumberTextbox(String licenceNumber) {
        waitForElementVisible(driver, PersonalDetailsPUI.DRIVER_LICENSE_NUMBER_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailsPUI.DRIVER_LICENSE_NUMBER_TEXTBOX, licenceNumber);
    }

    public void enterToLicenseExpiryDate(String yyyy, String mm, String dd) {
        waitForElementVisible(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_DATE_PICKER);
        sendKeyToElement(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_DATE_PICKER, yyyy + "-" + mm + "-" + dd);

    }

    public void selectNationalityDropdown(String countryName) {
        waitForElementVisible(driver, PersonalDetailsPUI.NATIONALITY_DROP_DOWN);
        selectItemInCustomDropdown(driver, PersonalDetailsPUI.NATIONALITY_DROP_DOWN, PersonalDetailsPUI.DROP_DOWN_OPTIONS, countryName);
    }

    public void selectMaritalStatusDropdown(String maritalStatus) {
        waitForElementVisible(driver, PersonalDetailsPUI.MARITAL_STATUS_DROP_DOWN);
        selectItemInCustomDropdown(driver, PersonalDetailsPUI.MARITAL_STATUS_DROP_DOWN, PersonalDetailsPUI.DROP_DOWN_OPTIONS, maritalStatus);

    }

    public void enterToDateOfBirth(String yyyy, String mm, String dd) {
        waitForElementVisible(driver, PersonalDetailsPUI.DATE_OF_BIRTH_DATE_PICKER);
        sendKeyToElement(driver, PersonalDetailsPUI.DATE_OF_BIRTH_DATE_PICKER, yyyy + "-" + mm + "-" + dd);
    }


    public void selectGender(String gender) {
        waitForElementVisible(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
        checkToTheCheckBoxOrRadio(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
    }

    public void clickPersonalDetailsSaveButton() {
        waitForElementClickable(driver, PersonalDetailsPUI.PERSONAL_DETAILS_SAVE_BUTTON);
        clickToElement(driver, PersonalDetailsPUI.PERSONAL_DETAILS_SAVE_BUTTON);
        waitForAllLoadingIconInvisible(driver);
    }

    public void clickToSaveButtonAtPersonalDetailsContainer() {
        waitForElementClickable(driver, PersonalDetailsPUI.ATTACHMENT_ADD_BUTTON);
        clickToElement(driver, PersonalDetailsPUI.ATTACHMENT_ADD_BUTTON);
    }

    public void uploadasAttachmentFile(String fileUrl) {
        uploadMultipleFiles(driver, fileUrl);
    }

    public void clickToSaveButtonAtAttachmentContainer() {
        waitForElementClickable(driver, PersonalDetailsPUI.ATTACHMENT_SAVE_BUTTON);
        clickToElement(driver, PersonalDetailsPUI.ATTACHMENT_SAVE_BUTTON);
        waitForAllLoadingIconInvisible(driver);
    }
}
