package org.binar.pages;

import org.binar.BaseTest;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class HomePage extends BaseTest {
    WebDriverWait wait;
    AndroidDriver driver;

    By productTitle = AppiumBy.accessibilityId("test-Cart drop zone");

    public HomePage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void validateOnHomePage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(productTitle));
        WebElement el = driver.findElement(productTitle);
        Assert.assertEquals(el.getTagName(), "test-Cart drop zone");
    }

}

