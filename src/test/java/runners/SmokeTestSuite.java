package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ui.methods.SetUp;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SetUp.class
})
public class SmokeTestSuite {
}


//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/resources/features",
//        glue = "com/imoving/UI/stepDefs",
//        tags = "@Smoke",
//        dryRun = false,
//        plugin = {
//                "pretty",
//                "html:target/default-cucumber-reports",
//                "json:target/cucumber.json"
//        },
//        publish = true
//)