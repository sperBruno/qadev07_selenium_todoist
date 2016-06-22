package comp.fundacionjala.todoistTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static final int  WAIT_TIME = 30;
    public static final int IMPLICIT_WAIT_TIME = 15;

    public static final int IMPLICIT_FAIL_WAIT_TIME = 4;

    private static String driverPath = ".\\lib\\";

    private static DriverManager instance;

    private WebDriver driver;

    private DriverManager() {
        initWebDriver();
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    private void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }
}