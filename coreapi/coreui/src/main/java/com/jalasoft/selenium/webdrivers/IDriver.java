package com.jalasoft.selenium.webdrivers;

import org.openqa.selenium.WebDriver;

/**
 * Created by Silvia Valencia on 2/2/2018.
 * Initialize the Selenium web driver.
 */
interface IDriver {

    /**
     * Initializes the Web Driver.
     *
     * @return WebDriver.
     */
    WebDriver initDriver();
}
