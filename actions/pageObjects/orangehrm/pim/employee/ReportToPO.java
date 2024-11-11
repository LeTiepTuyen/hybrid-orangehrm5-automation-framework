package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ReportToPO extends EmployeeNavigationPO {
    private WebDriver driver;

    public ReportToPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
