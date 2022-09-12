package stepsDefinition;

import appHooks.ApplicationHooks;
import common.PageGenerator;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePageObject;

public class HomePageSteps {
    WebDriver driver;
    HomePageObject homePage;

    public HomePageSteps() {
        this.driver = ApplicationHooks.openAndQuitBrowser();
        homePage = PageGenerator.getHomePage(driver);
    }

    @Given("User has opened login with Phone No form")
    public void user_has_opened_login_with_phone_no_form() {
        homePage.clickToLoginButtonById("btn-login-signInDialog");
    }

    @Given("User has opened personal register form")
    public void userHasOpenedPersonalRegisterForm() {
        homePage.clickToLoginButtonById("btn-header-register");
    }
}
