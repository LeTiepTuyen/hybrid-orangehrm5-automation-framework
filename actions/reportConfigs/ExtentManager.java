package reportConfigs;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import commons.GlobalConstants;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExtentManager {
    // Khởi tạo singleton ExtentReports
    private static final ExtentReports extent = createExtentReports(); // Đảm bảo khởi tạo ngay khi load lớp
    private static final Map<Long, ExtentTest> extentTestMap = new ConcurrentHashMap<>();

    // Tạo và cấu hình ExtentReports với ExtentSparkReporter
    private static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(GlobalConstants.EXTENT_PATH + "ExtentReport.html");

        reporter.config().setReportName("NopCommerce HTML Report");
        reporter.config().setDocumentTitle("NopCommerce HTML Report");
        reporter.config().setTimelineEnabled(true);
        reporter.config().setEncoding("utf-8");
        reporter.config().setTheme(Theme.DARK);

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Company", "Automation FC");
        extentReports.setSystemInfo("Project", "NopCommerce");
        extentReports.setSystemInfo("Team", "Automation Testing Team");
        extentReports.setSystemInfo("JDK version", GlobalConstants.JAVA_VERSION);
        extentReports.setSystemInfo("OS version", GlobalConstants.OS_NAME);
        return extentReports;
    }

    // Bắt đầu một test mới và trả về ExtentTest
    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.createTest(testName, desc); // Sử dụng extent đã được khởi tạo
        extentTestMap.put(Thread.currentThread().getId(), test);
        return test;
    }

    // Lấy đối tượng ExtentTest đang chạy theo thread ID
    public static synchronized ExtentTest getTest() {
        return extentTestMap.get(Thread.currentThread().getId());
    }

    // Đẩy toàn bộ log vào báo cáo và ghi ra file HTML
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
