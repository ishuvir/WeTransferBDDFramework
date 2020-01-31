package MyRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		features ="C:\\Users\\Ishuvir singh\\Downloads\\CucumberSeleniumFramework-master\\WeTransfer_AutomationFramework\\src\\main\\java\\Features\\WeTransferUpload.feature",
	    glue= {"StepDefination"},
	    		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
	    				"junit:target/cucumber-reports/Cucumber.xml",
	    				"html:target/cucumber-reports"},
	    monochrome = true
        )
    
public class TestRunner {

}
