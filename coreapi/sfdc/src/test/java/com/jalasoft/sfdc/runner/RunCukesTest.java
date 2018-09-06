package com.jalasoft.sfdc.runner;


import com.jalasoft.sfdc.AutomationSFDC;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by Silvia Valencia on 6/15/2018.
 * Runner class for the tests.
 */
public class RunCukesTest extends AbstractTestNGCucumberTests {
    private Logger log = Logger.getLogger(getClass());

    /**
     * Starts the execution.
     */
    @BeforeTest
    public void beforeExecution() {
        try {
            AutomationSFDC.getInstance().startUp();
        } catch (Exception e) {
            log.error("Exception in before execution", e);
        }
    }

    /**
     * Closes the execution.
     */
    @AfterTest
    public void afterExecution() {
        try {
            AutomationSFDC.getInstance().shutDown();
        } catch (Exception e) {
            log.error("Exception in after execution", e);
        }
    }
}
