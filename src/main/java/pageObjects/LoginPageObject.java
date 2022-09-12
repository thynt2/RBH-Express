package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickToCloseIcon(){
        waitElementClickable(driver, LoginPageUI.CLOSE_ICON);
        clickToElement(driver, LoginPageUI.CLOSE_ICON);
    }
    public boolean isLoginFormClosed(){
        waitForElementUndisplayed(driver, LoginPageUI.LOGO_IMG);
        return isElementUndisplay(driver, LoginPageUI.LOGO_IMG);
    }
}
