package com.jalasoft.selenium.webdrivers;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Silvia Valencia on 2/2/2018.
 * Handles FireFox driver initialization.
 */
class FireFox implements IDriver {

    /**
     * Initializes FireFox driver.
     * @return A new FireFoxDriver.
     */
    @Override
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance().version("0.19.0").setup();
        return new FirefoxDriver();
    }
}
