package stepsDefinition;

import appHooks.ApplicationHooks;
import common.PageGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

public class HomePageSteps {
    WebDriver driver;
    HomePageObject homePage;

    public HomePageSteps() {
        this.driver = ApplicationHooks.openAndQuitBrowser();
        homePage = PageGenerator.getHomePage(driver);
    }

    @Then("Verify user login success")
    public void verify_user_login_success() {
        Assert.assertTrue(homePage.isLoginsuccess());
    }

    @When("Hover mouse to Admin page")
    public void hoverMouseToAdminPage() {
        homePage.hoverToAdmin();
    }

    @And("Click to Company Profile page")
    public void clickToCompanyProfilePage() {
        homePage.clickToCompanyProfilePage();
    }

}
