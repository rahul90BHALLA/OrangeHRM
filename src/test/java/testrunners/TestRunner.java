package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = { "src/test/resources/com/features" }, //how to read folder path
               glue = { "stepdefinitions", "AppHooks" },
               plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
               
           
              ,monochrome= true, publish= true
            )

public class TestRunner extends AbstractTestNGCucumberTests {

}