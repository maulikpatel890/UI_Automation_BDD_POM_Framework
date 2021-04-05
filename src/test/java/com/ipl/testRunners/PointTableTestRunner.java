package com.ipl.testRunners;

import base.BaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/ipl/steps"},
        plugin = {"json:target/cucumber-report/cucumber_pointTable.json", "rerun:target/failed_scenarios_pointTable.txt"}
)

public class PointTableTestRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setupFramework() throws Exception {
        BaseClass baseClass = new BaseClass();
        baseClass.setUp();
    }

    @AfterSuite()
    public void tearDown(){
        if(BaseClass.driver!=null){
            BaseClass.driver.quit();
        }
    }
}