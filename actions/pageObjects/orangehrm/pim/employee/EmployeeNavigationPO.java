package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.orangehrm.PageGeneratorManager;
import pageUIs.nopCommerce.users.UserSideBarUI;
import pageUIs.orangehrm.pim.employee.EmployeeNavigationPUI;

public class EmployeeNavigationPO extends BasePage {
    WebDriver driver;

    public EmployeeNavigationPO(WebDriver driver) {
        this.driver = driver;
    }

    public EmployeeNavigationPO openEmployeeSideNavigationPageByName(String pageName) {
        waitForElementClickable(driver, EmployeeNavigationPUI.DYNAMIC_PAGE_LINK_BY_NAME, pageName);
        scrollToTopViewPortByJS(driver);
        clickToElement(driver, EmployeeNavigationPUI.DYNAMIC_PAGE_LINK_BY_NAME, pageName);

        // Sử dụng switch expression với cú pháp mới từ JDK 17
        try {
            return switch (pageName.toLowerCase()) {
                case "personal details" -> PageGeneratorManager.getPersonalDetailsPage(driver);
                case "contact details" -> PageGeneratorManager.getContactDetailslPage(driver);
                case "emergency contacts" -> PageGeneratorManager.getEmergencyContactsPage(driver);
                case "dependents" -> PageGeneratorManager.getDependentsPage(driver);
                case "immigration" -> PageGeneratorManager.getImmigrationPage(driver);
                case "job" -> PageGeneratorManager.getJobPage(driver);
                case "salary" -> PageGeneratorManager.getSalaryPage(driver);
                case "report-to" -> PageGeneratorManager.getReportToPage(driver);
                case "qualifications" -> PageGeneratorManager.getQualificationsPage(driver);
                case "memberships" -> PageGeneratorManager.getMembershipsPage(driver);
                default -> {
                    System.out.println("Page name not recognized: " + pageName);
                    yield null;
                }
            };
        } finally {
            waitForAllLoadingIconInvisible(driver);
        }
    }


}
