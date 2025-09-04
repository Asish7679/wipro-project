package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "classpath:Features",
	    glue = "stepdefinitions",
	    plugin = {"pretty", "html:target/cucumber-reports.html"}
	 //   tags = "@Login or @Logout or @Cart or @Checkout or @Smoke or @Regression"
	)
public class TestRunner extends AbstractTestNGCucumberTests {

//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
// 		}
    }

