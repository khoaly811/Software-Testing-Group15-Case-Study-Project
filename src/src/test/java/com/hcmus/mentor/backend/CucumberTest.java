package com.hcmus.mentor.backend;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.hcmus.mentor.backend", "com.hcmus.mentor.backend.steps"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-html-report.html"}
)
@Test
public class CucumberTest extends AbstractTestNGCucumberTests {

}