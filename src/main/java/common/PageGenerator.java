package common;

import org.openqa.selenium.WebDriver;
import pageObjects.CompanyProfilePageObject;
import pageObjects.LoginPageObject;
import pageObjects.HomePageObject;

public class PageGenerator {

    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }
    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }
    public static CompanyProfilePageObject getCompanyProfilePage(WebDriver driver) {
        return new CompanyProfilePageObject(driver);
    }
}
