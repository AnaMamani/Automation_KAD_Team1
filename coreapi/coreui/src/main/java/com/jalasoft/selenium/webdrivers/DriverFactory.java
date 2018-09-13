package com.jalasoft.selenium.webdrivers;

import com.jalasoft.selenium.WebDriverConfigReader;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Silvia Valencia on 2/2/2018.
 * Returns the correct instance of the driver.
 */
public final class DriverFactory {

    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";

    /**
     * Constructor.
     */
    private DriverFactory() {
    }

    /**
     * Gets the correct instance of IWebDriver according the name given by parameter.
     * @return The instance of web driver.
     */
    public static WebDriver getDriver() {
        Map<String, IDriver> strategyBrowser = new HashMap<String, IDriver>();
        strategyBrowser.put(FIREFOX, new FireFox());
        strategyBrowser.put(CHROME, new Chrome());

        return strategyBrowser.get(WebDriverConfigReader.getInstance().getBrowser().toLowerCase()).initDriver();
    }
}
