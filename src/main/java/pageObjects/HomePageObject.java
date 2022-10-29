package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isLoginsuccess(){
        waitForElementVisible(driver, HomePageUI.IMAGE_LOGO);
        return isElementDisplayed(driver, HomePageUI.IMAGE_LOGO);
    }
    public void hoverToAdmin(){
        waitForElementVisible(driver, HomePageUI.ADMIN_PAGE);
        hoverMouseToElement(driver, HomePageUI.ADMIN_PAGE);
    }
    public void clickToCompanyProfilePage(){
        waitForElementVisible(driver, HomePageUI.COMPANY_PROFILE);
        clickToElement(driver, HomePageUI.COMPANY_PROFILE);
    }
}
