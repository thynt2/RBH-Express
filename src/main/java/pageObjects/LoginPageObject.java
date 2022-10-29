package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
public void inputToEmail(String email){
        waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, email);
}
public void inputToPassword(String password){
    waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
    sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
}
public void clickToLoginButton(){
    waitElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
    clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
}
}
