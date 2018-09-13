package com.jalasoft.sfdc;

import com.jalasoft.selenium.WebDriverConfigReader;
import com.jalasoft.selenium.WebDriverManager;
import com.jalasoft.sfdc.config.ServersConfigReader;
import com.jalasoft.sfdc.config.UsersConfigReader;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;

/**
 * Initialize the configuration.
 *
 * @author Silvia Valencia
 * @since 6/11/2018
 */
public final class AutomationSFDC {
    private Logger log = Logger.getLogger(getClass());

    private final String webDriverConfigFilename =
            System.getProperty("user.dir") + File.separator + "config" + File.separator + "WebDriverConfig.json";
    private final String usersConfigFileName =
            System.getProperty("user.dir") + File.separator + "config" + File.separator + "SFDCUsers.json";
    private final String serversConfigFileName =
            System.getProperty("user.dir") + File.separator + "config" + File.separator + "SFDCServers.json";

    private static AutomationSFDC instance;

    /**
     * Constructor method to initialize the necessary configuration.
     */
    private AutomationSFDC() {
        PropertyConfigurator.configure("log.properties");
        WebDriverConfigReader.getInstance().initialize(webDriverConfigFilename);
        UsersConfigReader.getInstance().initialize(usersConfigFileName);
        ServersConfigReader.getInstance().initialize(serversConfigFileName);
    }

    /**
     * Gets a new instance if it is null.
     *
     * @return the instance of SelectSiteAutomation.
     */
    public static AutomationSFDC getInstance() {
        if (instance == null) {
            instance = new AutomationSFDC();
        }
        return instance;
    }

    /**
     * Starts the execution.
     */
    public void startUp() {
        log.info("-----Start Automation execution-----");
        WebDriverManager.getInstance().initialize();

        //Call to main setup
//        MainSetup mainSetup = new MainSetup();
//        mainSetup.beforeExecution();
    }

    /**
     * Ends the execution.
     */
    public void shutDown() {
//        MainSetup.afterExecution();
        WebDriverManager.getInstance().quitDriver();
    }
}
