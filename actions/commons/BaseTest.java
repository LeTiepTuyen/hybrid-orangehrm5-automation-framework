package commons;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected final Logger log;
    private WebDriver driver;

    public BaseTest() {
        log = LogManager.getLogger(getClass());
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX -> {
//              System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//                driver = WebDriverManager.firefoxdriver().create();
                driver = new FirefoxDriver();

            }
            case CHROME -> {
//                System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//                driver = WebDriverManager.chromedriver().create();
                driver = new ChromeDriver();

            }
            case EDGE -> {
//                System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
//                driver = WebDriverManager.edgedriver().create();
                driver = new EdgeDriver();

            }
            case SAFARI -> driver = new SafariDriver();
            default -> throw new IllegalArgumentException("Browser name is not valid: " + browserName);
        }


        driver.get("http://demo.nopcommerce/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String url) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX -> {
//              System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//                driver = WebDriverManager.firefoxdriver().create();
                driver = new FirefoxDriver();

            }
            case CHROME -> {
//                System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//                driver = WebDriverManager.chromedriver().create();
                driver = new ChromeDriver();

            }
            case EDGE -> {
//                System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
//                driver = WebDriverManager.edgedriver().create();
                driver = new EdgeDriver();

            }
            case SAFARI -> driver = new SafariDriver();
            default -> throw new IllegalArgumentException("Browser name is not valid: " + browserName);
        }


        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }

    protected String generatedRandomNumber() {
        return new Random().nextInt(999999) + "";
    }

    protected boolean verifyTrue(boolean condition) {
        boolean status = true;
        try {
            Assert.assertTrue(condition);
            log.info("-----------------------PASSED-----------------------");
        } catch (Throwable e) {
            status = false;
            log.info("-----------------------FAILED-----------------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean status = true;
        try {
            Assert.assertFalse(condition);
            log.info("-----------------------PASSED-----------------------");
        } catch (Throwable e) {
            status = false;
            log.info("-----------------------FAILED-----------------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean status = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("-----------------------PASSED-----------------------");
        } catch (Throwable e) {
            status = false;
            log.info("-----------------------FAILED-----------------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    @BeforeSuite
    public void deleteFileInReport() {
        // Remove all file in ReportNG screenshot (image)
        deleteAllFileInFolder("ReportNGScreenShots");


    }

    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }


    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = GlobalConstants.OS_NAME;
            log.info("OS name = " + osName);


            String driverInstanceName = (driver != null) ? driver.toString().toLowerCase() : "";
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = switch (driverInstanceName) {
                case String name when name.contains("chrome") -> "chromedriver";
                case String name when name.contains("internetexplorer") -> "IEDriverServer";
                case String name when name.contains("firefox") -> "geckodriver";
                case String name when name.contains("edge") -> "msedgedriver";
                case String name when name.contains("opera") -> "operadriver";
                default -> "safaridriver";
            };
            // Tạo lệnh dừng driver theo hệ điều hành
            cmd = osName.toLowerCase().contains("windows")
                    ? "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\""
                    : "pkill " + browserDriverName;

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
                log.info("Browser closed successfully.");
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder(cmd.split(" "));
                Process process = processBuilder.start();
                if (!process.waitFor(5, TimeUnit.SECONDS)) {
                    log.warn("Process termination timed out.");
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                log.info("Error during closing driver: " + e.getMessage());
            }
        }
    }

    
}
