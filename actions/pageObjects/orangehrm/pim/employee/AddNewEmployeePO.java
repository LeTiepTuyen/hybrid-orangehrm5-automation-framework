package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGeneratorManager;
import pageUIs.orangehrm.pim.employee.AddNewEmployeePUI;

public class AddNewEmployeePO extends BasePage {
    private WebDriver driver;

    public AddNewEmployeePO(WebDriver driver) {
        this.driver = driver;
    }


    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, AddNewEmployeePUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, AddNewEmployeePUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, AddNewEmployeePUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, AddNewEmployeePUI.LAST_NAME_TEXTBOX, lastName);

    }

    public String getEmployeeID() {
        waitForElementVisible(driver, AddNewEmployeePUI.EMPLOYEE_ID_TEXTBOX);
        return getDOMPropertyValue(driver, AddNewEmployeePUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public PersonalDetailsPO clickToSaveButtonAtAddEmployeeContainer() {
        waitForElementClickable(driver, AddNewEmployeePUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        clickToElement(driver, AddNewEmployeePUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        waitForAllLoadingIconInvisible(driver);
        return PageGeneratorManager.getPersonalDetailsPage(driver);
    }
}
