package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToButtonById(String buttonId) {
        waitElementClickable(driver, RegisterPageUI.DYNAMIC_BUTTON_BY_ID, buttonId);
        clickToElement(driver, RegisterPageUI.DYNAMIC_BUTTON_BY_ID, buttonId);
    }

    public String getErrorTextByID(String errorMsgId) {
        waitElementVisible(driver, RegisterPageUI.DYNAMIC_ERROR_MSG_BY_ID, errorMsgId);
        return getElementText(driver, RegisterPageUI.DYNAMIC_ERROR_MSG_BY_ID, errorMsgId);
    }
}
