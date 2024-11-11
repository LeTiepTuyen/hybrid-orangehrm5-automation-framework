package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class SalaryPO extends EmployeeNavigationPO {
    private WebDriver driver;

    public SalaryPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
