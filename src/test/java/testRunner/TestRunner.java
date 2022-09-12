package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepsDefinition"
                , "appHooks"
        },
        monochrome = true,
        publish = true,
        plugin = {
                "pretty", "html:target/site/cucumber.html", "json:target/site/cucumber.json"
        }
)
public class TestRunner {

}

