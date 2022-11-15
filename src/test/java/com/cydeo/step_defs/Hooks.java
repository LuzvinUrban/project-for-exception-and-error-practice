package com.cydeo.step_defs;


import com.cydeo.utilites.Driver;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

  @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
           TakesScreenshot ts= (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","failure_ss");
        }
        Driver.closeDriver();
    }
}
