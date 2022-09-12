package stepsDefinition;

import appHooks.ApplicationHooks;
import common.DataHelper;
import common.PageGenerator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPageObject;

public class LoginPageSteps {
    WebDriver driver;
    LoginPageObject loginPage;
    DataHelper dataTest;

    public LoginPageSteps() {
        this.driver = ApplicationHooks.openAndQuitBrowser();
        loginPage = PageGenerator.getLoginPage(driver);
    }

    @When("Check close login form when click close button")
    public void check_close_login_form_when_click_close_button() {
        loginPage.clickToCloseIcon();
    }

    @Then("Verify login form is closed")
    public void verifyLoginFormIsClosed() {
        Assert.assertTrue(loginPage.isLoginFormClosed());
    }
}


