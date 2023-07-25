package testrunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepdefinitions"},
        tags = "@SmokeTest",
        plugin  = {"json: test-reports/json-report.json"},
        monochrome = true
)


public class ActivitiesRunner {

    //empty
}
