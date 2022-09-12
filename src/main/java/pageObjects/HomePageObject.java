package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToLoginButtonById(String buttonId){
        waitElementClickable(driver, HomePageUI.DYNAMIC_BUTTON_BY_ID,buttonId);
        clickToElement(driver, HomePageUI.DYNAMIC_BUTTON_BY_ID,buttonId);
    }
}
