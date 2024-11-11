package com.orangehrm.pim;

import commons.BaseTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangehrm.DashboardPO;
import pageObjects.orangehrm.LoginPO;
import pageObjects.orangehrm.PageGeneratorManager;
import pageObjects.orangehrm.pim.employee.AddNewEmployeePO;
import pageObjects.orangehrm.pim.employee.ContactDetailsPO;
import pageObjects.orangehrm.pim.employee.EmployeeListPO;
import pageObjects.orangehrm.pim.employee.PersonalDetailsPO;

public class PIM_01_Employee extends BaseTest {

    private WebDriver driver;

    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;
    private AddNewEmployeePO addNewEmployeePage;
    private ContactDetailsPO contactDetailsPage;
    private String employeeID, firstName, lastName, avatarUrl;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {


        driver = getBrowserDriver(browserName, url);
        loginPage = PageGeneratorManager.getLoginPage(driver);

        firstName = "Nguyen";
        lastName = "Tuan";
        avatarUrl = "avatar.png";

        loginPage.enterToUserNameTextbox("tuyentieple");
        loginPage.enterToPasswordTextbox("XPs(#VJ7&1c@A*ROVs");
        dashboardPage = loginPage.clickToLoginButton();
    }

    @Test
    public void Employee_01_Add_New() {

        employeeListPage = dashboardPage.clickToPIMPage();
        addNewEmployeePage = employeeListPage.clickToAddEmployeeButton();

        addNewEmployeePage.enterToFirstNameTextbox(firstName);
        addNewEmployeePage.enterToLastNameTextbox(lastName);
        employeeID = addNewEmployeePage.getEmployeeID();
        personalDetailsPage = addNewEmployeePage.clickToSaveButtonAtAddEmployeeContainer();
        verifyEquals(personalDetailsPage.getEmployeeID(), employeeID);

    }

    @Test
    public void Employee_02_Upload_Avatar() {


        personalDetailsPage.clickToEmployeeAvatarImage();
        Dimension beforeUpload = personalDetailsPage.getAvatarSize();

        personalDetailsPage.uploadAvatarImage(avatarUrl);
        personalDetailsPage.clickToSaveButtonAtProfilePictureContainer();
        verifyTrue(personalDetailsPage.isSuccessMessageToasterDisplayed("Successfully Updated"));
        personalDetailsPage.waitForAllLoadingIconInvisible(driver);
        verifyTrue(personalDetailsPage.isAvatarImageUploadedSuccess(beforeUpload));

    }

    @Test
    public void Employee_03_Personal_Details() {
        personalDetailsPage = (PersonalDetailsPO) personalDetailsPage.openEmployeeSideNavigationPageByName("Personal Details");

        personalDetailsPage.enterToDriverLicenseNumberTextbox("123456789");
        personalDetailsPage.enterToLicenseExpiryDate("2022", "01", "31");
        personalDetailsPage.selectNationalityDropdown("Vietnamese");
        personalDetailsPage.selectMaritalStatusDropdown("Single");
        personalDetailsPage.enterToDateOfBirth("2002", "01", "31");
        personalDetailsPage.selectGender("Male");
        personalDetailsPage.clickPersonalDetailsSaveButton();

        personalDetailsPage.clickToSaveButtonAtPersonalDetailsContainer();
        personalDetailsPage.uploadasAttachmentFile(avatarUrl);
        personalDetailsPage.clickToSaveButtonAtAttachmentContainer();

    }

    @Test
    public void Employee_04_Contact_Details() {
        contactDetailsPage = (ContactDetailsPO) personalDetailsPage.openEmployeeSideNavigationPageByName("Contact Details");
        contactDetailsPage.enterToStreet1Textbox("123 Nguyen Trai");
        contactDetailsPage.enterToCityTextbox("Ha Noi");
        contactDetailsPage.enterProvinceTextbox("Ha Dong");
        contactDetailsPage.enterToZipTextbox("100000");
        contactDetailsPage.selectCountryByName("Viet Nam");
        contactDetailsPage.enterToMobileTextbox("0987654321");
        contactDetailsPage.enterToWorkEmailTextbox("fctuyen" + employeeID + "@gmail.com");
        contactDetailsPage.clickToSaveButtonAtContactDetailsContainer();

    }

    @Test
    public void Employee_06_Assigned_Dependents() {


    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

}
