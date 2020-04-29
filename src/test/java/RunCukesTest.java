import org.junit.runner.RunWith;
import cucumber.api.*;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/featureFiles"},
		format={"pretty","html:target/reports/test-report"},
		tags= "@smokeTest"
)
public class RunCukesTest {}
