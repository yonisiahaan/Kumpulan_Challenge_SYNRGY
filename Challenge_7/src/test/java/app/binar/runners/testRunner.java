package app.binar.runners;

import app.binar.browserFactory;
import app.binar.driverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import java.time.Duration;

@CucumberOptions(features = "src/test/java/app/binar/features",
        glue = "app.binar.steps",
        tags = "",
        plugin = {
                "pretty",
                "html:reports/cucumber-result/cucumber-reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:reports/cucumber-result/cucumber-reports.json"
        }, monochrome = true)

public class testRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel =  false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeMethod
    public void setupBrowser() {
        WebDriver webDriver = new browserFactory().launchBrowser("chrome");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driverManager.getInstance().setDriver(webDriver);
    }

    @AfterMethod
    public void teardownBrowser() {
        driverManager.getInstance().getDriver().close();
    }
}
