package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class DependentsPO extends EmployeeNavigationPO {
    WebDriver driver;

    public DependentsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
