package com.hcmus.mentor.backend.runners;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/excel",
        glue = {"com.hcmus.mentor.backend",
                "com.hcmus.mentor.backend.steps.CommonSteps",
                "com.hcmus.mentor.backend.steps.CreateMeetingStepsExcel",
                "com.hcmus.mentor.backend.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports/CreateMeeting.html",
                "json:target/cucumber-reports/CreateMeeting.json"},
        tags = "@excel"
)
@Test
public class TestRunnerExcel extends AbstractTestNGCucumberTests {

}