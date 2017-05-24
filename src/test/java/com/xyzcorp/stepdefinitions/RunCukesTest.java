package com.xyzcorp.stepdefinitions;


import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


//@CucumberOptions(plugin = {"pretty", "html:target/cucumber"})
@CucumberOptions(strict = false,features = "src/test/resources/com/xyzcorp", format = { "pretty",
        "html:target/site/cucumber-pretty","rerun:target/rerun.txt",
        "json:target/cucumber.json" }, tags = { "~@ignore" })
public class RunCukesTest extends AbstractTestNGCucumberTests {
    public static WebDriver driver;


    @BeforeClass
    public void setup(){
        System.out.println("Setup");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @AfterClass
    public void tearDown(){

        System.out.println("TearDown");
        driver.manage().deleteAllCookies();
        driver.close();
    }
}