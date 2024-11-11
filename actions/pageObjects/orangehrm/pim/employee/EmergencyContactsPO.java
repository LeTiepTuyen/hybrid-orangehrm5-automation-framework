package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class EmergencyContactsPO extends EmployeeNavigationPO {
    private WebDriver driver;

    public EmergencyContactsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
