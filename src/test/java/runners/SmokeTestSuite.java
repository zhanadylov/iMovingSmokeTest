package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ui.methods.SetUp;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SetUp.class
})
public class SmokeTestSuite {
}
