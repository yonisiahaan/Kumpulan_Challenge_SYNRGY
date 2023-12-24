package org.binar.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.binar.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class LoginPage extends BaseTest {
    WebDriverWait wait;
    AndroidDriver driver;

    By usernameTextBox = AppiumBy.accessibilityId("test-Username");
    By passwordTextBox = AppiumBy.accessibilityId("test-Password");
    By loginButton = AppiumBy.accessibilityId("test-LOGIN");
    By errorMessage = AppiumBy.xpath(
            "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView");


    public LoginPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void validateOnLoginPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameTextBox));
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordTextBox));
        wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
    }

    public void inputUsername(String username){
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameTextBox));
        driver.findElement(usernameTextBox).sendKeys(username);
    }

    public void inputPassword(String password){
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordTextBox));
        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public void clickLogin(){
        wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
    }

    public void verifyErrorAlertExist(String expectedMessage){
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        WebElement el = driver.findElement(errorMessage);
        String actualMessage = el.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }


}
