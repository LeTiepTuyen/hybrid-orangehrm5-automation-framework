package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import pageObjects.orangehrm.pim.configurations.*;
import pageObjects.orangehrm.pim.employee.*;
import pageObjects.orangehrm.pim.reports.AddNewReportPO;
import pageObjects.orangehrm.pim.reports.ReportSearchPO;

public class PageGeneratorManager {
    public static EmployeeListPO getEmployeeListPage(WebDriver driver) {
        return new EmployeeListPO(driver);
    }

    public static AddNewEmployeePO getAddNewEmployeePage(WebDriver driver) {
        return new AddNewEmployeePO(driver);
    }

    public static PersonalDetailsPO getPersonalDetailsPage(WebDriver driver) {
        return new PersonalDetailsPO(driver);
    }

    public static ContactDetailsPO getContactDetailslPage(WebDriver driver) {
        return new ContactDetailsPO(driver);
    }

    public static DependentsPO getDependentsPage(WebDriver driver) {
        return new DependentsPO(driver);
    }

    public static ImmigrationsPO getImmigrationPage(WebDriver driver) {
        return new ImmigrationsPO(driver);
    }

    public static SalaryPO getSalaryPage(WebDriver driver) {
        return new SalaryPO(driver);
    }

    public static JobPO getJobPage(WebDriver driver) {
        return new JobPO(driver);
    }

    public static EmergencyContactsPO getEmergencyContactsPage(WebDriver driver) {
        return new EmergencyContactsPO(driver);
    }

    public static ReportToPO getReportToPage(WebDriver driver) {
        return new ReportToPO(driver);
    }

    public static QualificationsPO getQualificationsPage(WebDriver driver) {
        return new QualificationsPO(driver);
    }

    public static MembershipsPO getMembershipsPage(WebDriver driver) {
        return new MembershipsPO(driver);
    }


    public static DashboardPO getDashboardPage(WebDriver driver) {
        return new DashboardPO(driver);
    }

    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }


    public static AddNewReportPO getAddNewReportPage(WebDriver driver) {
        return new AddNewReportPO(driver);
    }

    public static ReportSearchPO getReportSearchPage(WebDriver driver) {
        return new ReportSearchPO(driver);
    }


    public static CustomFieldsPO getCustomFieldsPage(WebDriver driver) {
        return new CustomFieldsPO(driver);
    }

    public static DataImportPO getDataImportPage(WebDriver driver) {
        return new DataImportPO(driver);
    }

    public static OptionalFieldsPO getOptionalFieldsPage(WebDriver driver) {
        return new OptionalFieldsPO(driver);
    }

    public static ReprotingMethodsPO getReprotingMethodsPage(WebDriver driver) {
        return new ReprotingMethodsPO(driver);
    }

    public static TerminationReasonsPO getTerminationReasonsPage(WebDriver driver) {
        return new TerminationReasonsPO(driver);
    }

    public static ProfilePicturePO getProfilePicturePage(WebDriver driver) {
        return new ProfilePicturePO(driver);
    }
}
