package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class JobPO extends EmployeeNavigationPO {
    private WebDriver driver;

    public JobPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
