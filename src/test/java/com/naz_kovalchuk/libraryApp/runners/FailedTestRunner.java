package com.naz_kovalchuk.libraryApp.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/naz_kovalchuk/libraryApp/step_definitions",
        features = "@target/rerun.txt"
)
public class FailedTestRunner {
}
