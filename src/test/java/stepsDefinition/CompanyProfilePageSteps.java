package stepsDefinition;

import appHooks.ApplicationHooks;
import common.PageGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.CompanyProfilePageObject;

public class CompanyProfilePageSteps {
    WebDriver driver;
    CompanyProfilePageObject companyProfilePage;
    String projectPath = System.getProperty("user.dir");
    String profileImage = "images.jpeg";
    String imagePath = projectPath + "\\images\\" + profileImage;

    public CompanyProfilePageSteps() {
        this.driver = ApplicationHooks.openAndQuitBrowser();
        companyProfilePage = PageGenerator.getCompanyProfilePage(driver);
    }

    @Then("Verify Company Profile page display success")
    public void verifyCompanyProfilePageDisplaySuccess() {
        Assert.assertTrue(companyProfilePage.isCompanyProfileTitleDisplayed());
    }

    @When("Upload new image success")
    public void uploadNewImageSuccess() {
        companyProfilePage.uploadImage(imagePath);
    }

    @And("Click Save button")
    public void clickSaveButton() {
        companyProfilePage.clickToSaveButton();
    }

    @When("Click Done button")
    public void clickDoneButton() {
        companyProfilePage.clickToDoneButton();
    }

    @Then("Click sign out button")
    public void clickSignOutButton() {
        companyProfilePage.clickToLogOutButton();
    }

    @Then("Verify success message will display")
    public void verifySuccessMessageWillDisplay() {
        Assert.assertTrue(companyProfilePage.isUploadSuccessMessageDisplayed());
    }
}
