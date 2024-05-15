package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumber",glue={"Shashankagra.StepDefinitions"},
monochrome=true,plugin={"html:target/Cucumber.html"})
public class TestngTestrunner extends AbstractTestNGCucumberTests {

}
