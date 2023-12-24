package org.binar.runner;

import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.binar.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@CucumberOptions(features = "src/test/java/org/binar/features",
        glue = "org.binar.stepdefs",
        tags = "",
        plugin = {
                "pretty",
                "html:reports/cucumber-result/cucumber-reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:reports/cucumber-result/cucumber-reports.json"
        }, monochrome = true)

public class RunnerTest extends AbstractTestNGCucumberTests {

        @BeforeMethod
        public static void beforeMethod(){
                BaseTest.setupDriver();
        }

        @AfterMethod
        public static void afterMethod(){
                BaseTest.stopDriver();
        }

        @After
        public static void after(){
                BaseTest.resetApp();
        }
}