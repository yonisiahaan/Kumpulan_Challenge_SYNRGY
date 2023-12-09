package app.binar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class browserFactory {

    public WebDriver launchBrowser(String browserName) {
        WebDriver webDriver;

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().clearDriverCache().setup();
            WebDriverManager.chromedriver().clearResolutionCache().setup();
            webDriver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("headless chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless", "--disable-gpu");
            webDriver = new ChromeDriver(chromeOptions);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("headless firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless", "--disable-gpu");
            webDriver = new FirefoxDriver(firefoxOptions);
        } else {
            throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }

        return webDriver;
    }
}
