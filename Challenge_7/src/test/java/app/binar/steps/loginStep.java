package app.binar.steps;

import app.binar.driverManager;
import app.binar.pages.homePage;
import app.binar.pages.loginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStep {
    @When("user login using {string}")
    public void loginAs(String credentialType) {

        String username;
        String password;

        switch (credentialType) {
            case "standard user" -> {
                username = "standard_user";
                password = "secret_sauce";
            }
            case "locked out user" -> {
                username = "locked_out_user";
                password = "secret_sauc";
            }
            case "problem user" -> {
                username = "problem_user";
                password = "secret_sauce";
            }
            default -> throw new RuntimeException("credential type doesn't exist");
        }
        loginPage loginPage = new loginPage(driverManager.getInstance().getDriver());
        loginPage.userLogin(username, password);
    }
    @Then("user direct to dashboard screen")
        public void userDirectToDashboardScreen() {
            new homePage(driverManager.getInstance().getDriver());
            homePage.verifyCartIconExist();

        }

    @Then("error alert exist with value {string}")
    public void errorAlertExist(String message) {
        new loginPage(driverManager.getInstance().getDriver());
        loginPage.verifyErrorAlertExist(message);

    }
    }
