package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.pim.employee.ContactDetailsPUI;

public class ContactDetailsPO extends EmployeeNavigationPO {
    private WebDriver driver;

    public ContactDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void enterToStreet1Textbox(String streetAddress) {
        waitForElementVisible(driver, ContactDetailsPUI.STREET1_TEXTBOX);
        sendKeyToElement(driver, ContactDetailsPUI.STREET1_TEXTBOX, streetAddress);
    }

    public void enterToCityTextbox(String city) {
        waitForElementVisible(driver, ContactDetailsPUI.CITY_TEXTBOX);
        sendKeyToElement(driver, ContactDetailsPUI.CITY_TEXTBOX, city);
    }

    public void enterProvinceTextbox(String province) {
        waitForElementVisible(driver, ContactDetailsPUI.DYNAMIC_CONTACT_DETAILS_TEXTBOX_BY_LABEL, "State/Province");
        sendKeyToElement(driver, ContactDetailsPUI.DYNAMIC_CONTACT_DETAILS_TEXTBOX_BY_LABEL, province, "State/Province");
    }

    public void enterToZipTextbox(String zipNumber) {
        waitForElementVisible(driver, ContactDetailsPUI.DYNAMIC_CONTACT_DETAILS_TEXTBOX_BY_LABEL, "Zip/Postal Code");
        sendKeyToElement(driver, ContactDetailsPUI.DYNAMIC_CONTACT_DETAILS_TEXTBOX_BY_LABEL, zipNumber, "Zip/Postal Code");
    }

    public void selectCountryByName(String countryName) {
        waitForElementVisible(driver, ContactDetailsPUI.COUNTRY_DROPDOWN);
        selectItemInCustomDropdown(driver, ContactDetailsPUI.COUNTRY_DROPDOWN, ContactDetailsPUI.DROP_DOWN_OPTIONS, countryName);

    }

    public void enterToMobileTextbox(String phoneNumber) {
        waitForElementVisible(driver, ContactDetailsPUI.DYNAMIC_CONTACT_DETAILS_TEXTBOX_BY_LABEL, "Mobile");
        sendKeyToElement(driver, ContactDetailsPUI.DYNAMIC_CONTACT_DETAILS_TEXTBOX_BY_LABEL, phoneNumber, "Mobile");
    }

    public void enterToWorkEmailTextbox(String emailAdress) {
        waitForElementVisible(driver, ContactDetailsPUI.DYNAMIC_CONTACT_DETAILS_TEXTBOX_BY_LABEL, "Work Email");
        sendKeyToElement(driver, ContactDetailsPUI.DYNAMIC_CONTACT_DETAILS_TEXTBOX_BY_LABEL, emailAdress, "Work Email");
    }

    public void clickToSaveButtonAtContactDetailsContainer() {
        waitForElementClickable(driver, ContactDetailsPUI.SAVE_BUTTON_AT_CONTACT_DETAILS_CONTAINER);
        clickToElement(driver, ContactDetailsPUI.SAVE_BUTTON_AT_CONTACT_DETAILS_CONTAINER);
        waitForAllLoadingIconInvisible(driver);
    }
}
