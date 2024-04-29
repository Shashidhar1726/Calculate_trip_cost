package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
					features= {".//Features/"},
					glue="stepDefinitions",
					plugin= {"pretty", "html:reports/myreport.html", 
							  "rerun:target/rerun.txt",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							},
							dryRun=false,    // checks mapping between scenario steps and step definition methods
							monochrome=true,    // to avoid junk characters in output
							publish=true   // to publish report in cucumber server
							//tags="@smoke" //this will execute scenarios with sanity tag
							//tags="@regression"
							//tags="@functional"
							//tags="@smoke and @regression"
							//tags="@smoke or @regression"
							//tags="@smoke and @functional"
							//tags="@regression and @functional"      
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
