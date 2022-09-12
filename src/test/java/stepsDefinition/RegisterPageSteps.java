package stepsDefinition;

import appHooks.ApplicationHooks;
import common.DataHelper;
import common.Message;
import common.PageGenerator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.RegisterPageObject;

public class RegisterPageSteps {
    WebDriver driver;
    RegisterPageObject registerPage;
    DataHelper dataTest;

    public RegisterPageSteps() {
        this.driver = ApplicationHooks.openAndQuitBrowser();
        registerPage = PageGenerator.getLRegisterPage(driver);
    }

    @When("Click submit button")
    public void clickSubmitButton() {
        registerPage.clickToButtonById("btn-onboarding-register-personal-form-submit");
    }

    @Then("Check validation message at required fields")
    public void checkValidationMessageAtRequiredFields() {
        Assert.assertEquals(registerPage.getErrorTextByID("txt-onboarding-register-personal-form-firstName-helper-text"), Message.FIRSTNAME_IS_EMPTY);
    }
}

