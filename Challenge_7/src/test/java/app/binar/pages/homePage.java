package app.binar.pages;

import app.binar.driverManager;
import app.binar.keyword;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class homePage {

    protected WebDriver webDriver;

    public homePage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(id = "shopping_cart_container")
    private static WebElement cart_icon;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private static WebElement add_to_cart1;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private static WebElement add_to_cart2;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private static WebElement badge_cart;

    @FindBy(id = "checkout")
    private static WebElement checkout_button;

    @FindBy(id = "first-name")
    private static WebElement input_firstname;

    @FindBy(id = "last-name")
    private static WebElement input_lastname;

    @FindBy(id = "postal-code")
    private static WebElement input_postalcode;

    @FindBy(id = "continue")
    private static WebElement continue_button;

    @FindBy(id = "finish")
    private static WebElement finish_button;

    @FindBy(xpath = "//span[@class='title']")
    private static WebElement success_checkout;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private static WebElement select_filter;

    public static void comparePrice(WebDriver driver) {
        List<WebElement> itemPrices = driver.findElements(By.className("inventory_item_price"));
        boolean isSorted = isPriceSorted(itemPrices);

        Assert.assertTrue(isSorted, "Items are not sorted by price (high to low)");
    }
    private static boolean isPriceSorted(List<WebElement> itemPrices) {
        for (int i = 0; i < itemPrices.size() - 1; i++) {
            double value1 = extractNumericValue(itemPrices.get(i));
            double value2 = extractNumericValue(itemPrices.get(i + 1));

            if (value1 < value2) {
                return false;
            }
        }
        return true;
    }

    private static double extractNumericValue(WebElement element) {
        String priceText = element.getText().replace("$", "");
        return Double.parseDouble(priceText);
    }

    public static void verifyCartIconExist(){
        keyword.validate_element_is_visible_and_enabled(cart_icon);
    }
    public static void TapAddToCart(){
        keyword.tapElement(add_to_cart1);
        keyword.validate_element_is_visible_and_enabled(badge_cart);

        keyword.tapElement(add_to_cart2);
        keyword.validate_element_is_visible_and_enabled(badge_cart);
    }

    public static void doCheckout(String firstName, String lastName, String postalCode){
        keyword.tapElement(cart_icon);
        keyword.tapElement(checkout_button);
        keyword.inputText(input_firstname, firstName);
        keyword.inputText(input_lastname, lastName);
        keyword.inputText(input_postalcode, postalCode);
        keyword.tapElement(continue_button);
        keyword.tapElement(finish_button);
    }

    public static void verifySuccessCheckout(){
        keyword.validate_element_is_visible_and_enabled(success_checkout);
    }

    public static void selectFilter(String value){
        keyword.selectOption(select_filter, value);
    }


}
