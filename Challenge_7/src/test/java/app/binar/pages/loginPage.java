package app.binar.pages;

import app.binar.keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class loginPage {
    protected WebDriver webDriver;

    public loginPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "user-name")
    private static WebElement input_username;

    @FindBy(id = "password")
    private static WebElement input_password;

    @FindBy(id = "login-button")
    private static WebElement login_button;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    private static WebElement error_alert;

    public void userLogin(String username, String password) {
        keyword.inputText(input_username, username);
        keyword.inputText(input_password, password);
        keyword.tapElement(login_button);
    }

    public static void verifyErrorAlertExist(String expectedMessage){
        String actual = error_alert.getText();
        Assert.assertEquals(actual,expectedMessage );
    }
}
