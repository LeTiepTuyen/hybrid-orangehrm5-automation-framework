package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class MembershipsPO extends EmployeeNavigationPO {
    private WebDriver driver;

    public MembershipsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
