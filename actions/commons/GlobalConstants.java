package commons;

public class GlobalConstants {

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");


    public static final String DEV_USER_URL = "http://dev.techpanda.org/";
    public static final String STAGING_USER_URL = "http://staging.techpanda.org/";
    public static final String LIVE_USER_URL = "http://live.techpanda.org/";

    public static final String DEV_ADMIN_URL = "http://dev.techpanda.org/index.php/backendlogin";
    public static final String STAGING_ADMIN_URL = "http://staging.techpanda.org/index.php/backendlogin";
    public static final String LIVE_ADMIN_URL = "http://live.techpanda.org/index.php/backendlogin";
    public static final String ADMIN_USERNAME = "user01";
    public static final String ADMIN_PASSWORD = "guru99com";


    public static final long SHORT_TIMEOUT = 10;
    public static final long LONG_TIMEOUT = 30;


    public static final String UPLOAD_PATH = PROJECT_PATH + FILE_SEPARATOR + "uploadFiles" + FILE_SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + FILE_SEPARATOR + "downloadFiles" + FILE_SEPARATOR;

    public static final int RETRY_NUMBER = 3;

    public static final String BROWSER_LOG_PATH = PROJECT_PATH + FILE_SEPARATOR + "browserLogs" + FILE_SEPARATOR;
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + FILE_SEPARATOR + "browserExtensions" + FILE_SEPARATOR;


    public static final String REPORTING_PATH = PROJECT_PATH + FILE_SEPARATOR + "htmlReportNG" + FILE_SEPARATOR;
    public static final String EXTENT_PATH = PROJECT_PATH + FILE_SEPARATOR + "htmlExtent" + FILE_SEPARATOR;
    public static final String ALLURE_PATH = PROJECT_PATH + FILE_SEPARATOR + "htmlAllure" + FILE_SEPARATOR;

    public static final String DATA_TEST_PATH = PROJECT_PATH + FILE_SEPARATOR + "dataTest" + FILE_SEPARATOR;
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + FILE_SEPARATOR + "environmentConfig" + FILE_SEPARATOR;


    public static final String JIRA_SITE_URL = "https://automation-selenium-testing.atlassian.net";
    public static final String JIRA_API_KEY = "ATATT3xFfGF0S0Z0zQFdEnV-5R3HypbMQ_d1cd4428enPToFlTXuEyV_WC9AG4Brc-0HzDBpcqfyyLDF5UV4X-ou-ItTyWbD4anaxuqzQEOYPWs0CCmBtt4laO5zRLG9mZVfqu_S1MkNF_hFQjhwpIgwhjduLt3xZ0il8pXU42w-tdBzwKhqKOc=C8D61B20";
    public static final String JIRA_USER_NAME = "tuyentieple@gmail.com";
    public static final String JIRA_PROJECT_KEY = "SCRUM";

}
