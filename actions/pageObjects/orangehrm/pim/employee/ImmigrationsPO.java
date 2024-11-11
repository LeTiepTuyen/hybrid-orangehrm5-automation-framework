package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ImmigrationsPO extends EmployeeNavigationPO {
    private WebDriver driver;

    public ImmigrationsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
