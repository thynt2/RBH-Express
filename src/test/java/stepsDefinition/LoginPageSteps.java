package stepsDefinition;

import appHooks.ApplicationHooks;
import common.BasePage;
import common.PageGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPageObject;

public class LoginPageSteps extends BasePage {
    WebDriver driver;
    LoginPageObject loginPage;

    public LoginPageSteps() {
        this.driver = ApplicationHooks.openAndQuitBrowser();
        loginPage = PageGenerator.getLoginPage(driver);
    }

    @When("Input data into required field")
    public void input_data_into_required_field() {
        loginPage.inputToEmail("trxautotest001@qa.team");
        loginPage.inputToPassword("Trx@2020");

    }

    @And("Click Login button")
    public void clickLoginButton() {
        loginPage.clickToLoginButton();

    }

    @And("Back to previous page")
    public void backToPreviousPage() {
        loginPage.backToPage(driver);
    }
}
