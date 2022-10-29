package common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static BasePage getBasePageObject() {
        return new BasePage();
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public By getByLocator(String locatorType) {
        By by = null;
        if (locatorType.startsWith("id") || locatorType.startsWith("ID") || locatorType.startsWith("Id")) {
            by = By.id(locatorType.substring(3));
        } else if (locatorType.startsWith("class") || locatorType.startsWith("CLASS") || locatorType.startsWith("Class")) {
            by = By.className(locatorType.substring(6));
        } else if (locatorType.startsWith("name") || locatorType.startsWith("NAME") || locatorType.startsWith("Name")) {
            by = By.name(locatorType.substring(5));
        } else if (locatorType.startsWith("css") || locatorType.startsWith("CSS") || locatorType.startsWith("Css")) {
            by = By.cssSelector(locatorType.substring(4));
        } else if (locatorType.startsWith("xpath") || locatorType.startsWith("XPATH") || locatorType.startsWith("Xpath")) {
            by = By.xpath(locatorType.substring(6));
        } else {
            throw new RuntimeException("Locator type is not support!");
        }
        return by;
    }

    public WebElement getWebElement(WebDriver driver, String locatorType) {
        return driver.findElement(getByLocator(locatorType));
    }
    public void clickToElement(WebDriver driver, String locatorType) {
        getWebElement(driver, locatorType).click();
    }

    public void sendKeyToElement(WebDriver driver, String locatorType, String value) {
        WebElement element = getWebElement(driver, locatorType);
        element.clear();
        element.sendKeys(value);
    }

    public String getElementText(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).getText().trim();
    }

    public boolean isElementDisplayed(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).isDisplayed();

    }
    public void waitElementClickable(WebDriver driver, String locatorType) {
        WebDriverWait wait = new WebDriverWait(driver, GlobalConstants.getGlobalConstants().getLongTimeout());
        wait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
    }
    public void hoverMouseToElement(WebDriver driver, String locatorType) {
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(driver, locatorType)).perform();
    }
    public void waitForElementVisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
    }
    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }
    public void switchToFrameIframe(WebDriver driver, String locatorType) {
        driver.switchTo().frame(getWebElement(driver, locatorType));
    }
}
