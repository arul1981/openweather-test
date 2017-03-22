package org.openweather.stepdefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/openweather/features",
        glue = "org/openweather/stepdefinitions",
        plugin = { 
                    "pretty",
                    "html:target/cucumber",
                 } 
        )
public class RunCukeTest {
}