package com.jquery;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.PageGenerator;

public class Level_12_Upload_Files extends BaseTest {

    private WebDriver driver;

    private HomePO homePage;

    private String coban1FileName;
    private String coban2FileName;
    private String coban3FileName;

    public static void main(String[] args) {
        // Lấy thông tin hệ điều hành
        System.out.println("Operating System: " + System.getProperty("os.name"));
        System.out.println("OS Version: " + System.getProperty("os.version"));
        System.out.println("OS Architecture: " + System.getProperty("os.arch"));

        // Lấy thông tin người dùng
        System.out.println("User Name: " + System.getProperty("user.name"));
        System.out.println("User Home Directory: " + System.getProperty("user.home"));
        System.out.println("User Working Directory: " + System.getProperty("user.dir"));

        // Lấy thông tin về Java
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Java Home: " + System.getProperty("java.home"));

        // Lấy thông tin về các ký tự phân cách hệ điều hành
        System.out.println("File Separator: " + System.getProperty("file.separator"));
        System.out.println("Path Separator: " + System.getProperty("path.separator"));
        System.out.println("Line Separator: " + System.getProperty("line.separator"));

        System.out.println("" + System.lineSeparator());
    }

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {


        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);

        coban1FileName = "coban1.jpg";
        coban2FileName = "coban2.jpg";
        coban3FileName = "coban3.jpg";

    }

    @Test
    public void Upload_01_Files() {
        homePage.uploadMultipleFiles(driver, coban1FileName, coban2FileName, coban3FileName);
        Assert.assertTrue(homePage.areFilesLoadedSuccess(coban1FileName, coban2FileName, coban3FileName));

        homePage.clickToStartButton();
        Assert.assertTrue(homePage.areFilesUploadedSuccess(coban1FileName, coban2FileName, coban3FileName));
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
