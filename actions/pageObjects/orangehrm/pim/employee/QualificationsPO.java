package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class QualificationsPO extends EmployeeNavigationPO {
    private WebDriver driver;

    public QualificationsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
