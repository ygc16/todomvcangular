package au.com.unisuper.utils;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/report/"},
        features = "src/test/resources/features"
        ,glue={"au.com.unisuper.stepdef"
        }
       // ,dryRun = true
)
/**
 * Created by att.jacobg on 21/10/2016.
 */
public class RunCukesTest {
    RunCukesTest() {
        System.out.println("##############################################");

    }
}