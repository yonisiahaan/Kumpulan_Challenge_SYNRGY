package app.binar.steps;

import app.binar.driverManager;
import app.binar.pages.homePage;
import app.binar.pages.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class checkoutStep {
    @And("user click Add To Cart button on product")
    public void user_click_Add_To_Cart() {
        new homePage(driverManager.getInstance().getDriver());
        homePage.TapAddToCart();
    }
    @And("user do checkout")
    public void user_do_checkout() {
        new homePage(driverManager.getInstance().getDriver());
        homePage.doCheckout("jokowi", "widodo", "22222");
    }
    @And("verify checkout successfully")
    public void verify_checkout_successfully() {
        new homePage(driverManager.getInstance().getDriver());
        homePage.verifySuccessCheckout();
    }
}
