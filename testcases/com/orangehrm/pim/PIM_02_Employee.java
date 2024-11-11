package com.orangehrm.pim;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PIM_02_Employee extends BaseTest {

    private WebDriver driver;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {


        driver = getBrowserDriver(browserName, url);


    }


    @Test
    public void Employee_07_Immigration() {


    }

    @Test
    public void Employee_08_Edit_View_Job() {


    }

    @Test
    public void Employee_09_Edit_View_Salary() {


    }

    @Test
    public void Employee_10_Report_To() {


    }

    @Test
    public void Employee_11_Qualifications() {


    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

}
