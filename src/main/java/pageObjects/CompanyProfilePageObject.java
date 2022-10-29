package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CompanyProfilePageUI;
import pageUIs.LoginPageUI;

public class CompanyProfilePageObject extends BasePage {
    WebDriver driver;

    public CompanyProfilePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCompanyProfileTitleDisplayed() {
        waitForElementVisible(driver, CompanyProfilePageUI.COMPANY_PROFILE_TITLE);
        return isElementDisplayed(driver, CompanyProfilePageUI.COMPANY_PROFILE_TITLE);
    }

    public void uploadImage(String image) {
        waitForElementVisible(driver, CompanyProfilePageUI.UPLOAD_IMAGE);
        sendKeyToElement(driver, CompanyProfilePageUI.UPLOAD_IMAGE, image);
    }

    public void clickToSaveButton() {
        waitForElementVisible(driver, CompanyProfilePageUI.SAVE_BUTTON);
        clickToElement(driver, CompanyProfilePageUI.SAVE_BUTTON);
    }

    public void clickToDoneButton() {
        waitForElementVisible(driver, CompanyProfilePageUI.DONE_BUTTON);
        clickToElement(driver, CompanyProfilePageUI.DONE_BUTTON);
    }

    public void clickToLogOutButton() {
        waitForElementVisible(driver, CompanyProfilePageUI.LOGOUT_BUTTON);
        clickToElement(driver, CompanyProfilePageUI.LOGOUT_BUTTON);
    }

    public boolean isUploadSuccessMessageDisplayed() {
        waitForElementVisible(driver, CompanyProfilePageUI.UPLOAD_SUCCESS_MESSAGE);
        return isElementDisplayed(driver, CompanyProfilePageUI.UPLOAD_SUCCESS_MESSAGE);

    }
}
