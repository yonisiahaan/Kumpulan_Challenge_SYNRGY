package org.binar.stepdefs;

import org.binar.pages.LoginPage;
import org.binar.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.binar.BaseTest;

public class LoginStepDef extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @And("user input valid username {string} and valid password {string}")
    public void inputValidUsernameValidPassword(String username, String password){
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
    }

    @And("user input valid username {string} and invalid password {string}")
    public void inputValidUsernameInvalidPassword(String username, String password){
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
    }

    @When("user click on the login button")
    public void clickLoginButton(){
       loginPage.clickLogin();
    }

    @Then("user direct to home page")
    public void directHomePage(){
        homePage.validateOnHomePage();
    }

    @Then("error alert exist with value {string}")
    public void errorAlertExist(String message){
        loginPage.verifyErrorAlertExist(message);
    }
}
