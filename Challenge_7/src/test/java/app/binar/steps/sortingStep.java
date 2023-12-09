package app.binar.steps;

import app.binar.driverManager;
import app.binar.pages.homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class sortingStep {

    @And("user select filter price high to low")
    public void user_select_filter() {
        new homePage(driverManager.getInstance().getDriver());
        homePage.selectFilter("hilo");
    }
    @Then("compare first product price with second product price")
    public void compare_product_price() {
        new homePage(driverManager.getInstance().getDriver());
        homePage.comparePrice(driverManager.getInstance().getDriver());
    }


}
