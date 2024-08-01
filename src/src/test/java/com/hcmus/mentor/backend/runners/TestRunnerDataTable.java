package com.hcmus.mentor.backend.runners;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/datatables",
        glue = {"com.hcmus.mentor.backend",
                "com.hcmus.mentor.backend.steps.CommonSteps",
                "com.hcmus.mentor.backend.steps.CreateMeetingSteps",
                "com.hcmus.mentor.backend.hooks"},
        plugin = {"pretty",
                "html:target/cucumber-reports/CreateMeeting.html",
                "json:target/cucumber-reports/CreateMeeting.json"},
        tags = "@datatableCreateAcc"
)
@Test
public class TestRunnerDataTable extends AbstractTestNGCucumberTests {

}