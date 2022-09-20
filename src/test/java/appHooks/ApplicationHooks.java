package appHooks;

import com.google.common.io.Files;
import common.GlobalConstants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ApplicationHooks {
    private static WebDriver driver;
    private static final Logger log = Logger.getLogger(ApplicationHooks.class.getName());

    @Before(order = 0)
    public synchronized static WebDriver openAndQuitBrowser() {
        String browser = System.getProperty("BROWSER");
        if (driver == null) {
            try {
                if (browser == null) {
                    browser = System.getenv("BROWSER");
                    if (browser == null) {
                        browser = "chrome";
                    }
                }
                switch (browser) {
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                        driver = new FirefoxDriver();
                        break;
                    case "hfirefox":
                        WebDriverManager.firefoxdriver().setup();
                        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.setHeadless(true);
                        driver = new FirefoxDriver(firefoxOptions);
                        break;
                    case "ie":
                        WebDriverManager.iedriver().arch32().setup();
                        driver = new InternetExplorerDriver();
                        break;
                    default:
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                }
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
            driver.manage().window().maximize();
            driver.get(GlobalConstants.getGlobalConstants().getDevUrl());
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.getGlobalConstants().getImplicitWaitTimeout()));
        }
        return driver;
    }
    @Before(order = 1)
    public void deleteAllFilesInReports() {
        try {
            String workingDir = System.getProperty("user.dir");
            String pathFolderDownload = workingDir + "/reports";
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    new File(listOfFiles[i].toString()).delete();
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }

    public static void close() {
        try {
            if (driver != null) {
                openAndQuitBrowser().quit();
            }
        } catch (UnreachableBrowserException e) {
            throw new RuntimeException("Can not close the browser");
        }
    }

    private static class BrowserCleanup implements Runnable {
        @Override
        public void run() {
            close();
        }
    }
    @After(order = 1)
    public void tearDown(Scenario scenario) {
        String screenshotName = scenario.getName().replaceAll(" ", "_");
        byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sourcePath, "image/png", screenshotName);
        System.out.println("tearDown");
    }

}
