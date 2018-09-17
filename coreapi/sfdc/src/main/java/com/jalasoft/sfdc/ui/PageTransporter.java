package com.jalasoft.sfdc.ui;

import com.jalasoft.selenium.WebDriverManager;
import com.jalasoft.sfdc.config.ServersConfigReader;
import com.jalasoft.sfdc.ui.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * PageTransporter class.
 *
 * @author Silvia Valencia
 * @since 6/20/2018
 */
public class PageTransporter {
    private Logger log = Logger.getLogger(getClass());
    private String baseURL = ServersConfigReader.getInstance().getURL();
    private WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();

    private static PageTransporter instance;

    /**
     * Constructor of page transporter.
     */
    protected PageTransporter() {
        initialize();
    }

    /**
     * Gets instance.
     *
     * @return the instance or a new instance.
     */
    public static PageTransporter getInstance() {
        if (instance == null) {
            instance = new PageTransporter();
        }
        return instance;
    }

    /**
     * Initializes page transporter.
     */
    private void initialize() {
        log.info("Initialize the page transporter");
    }

    /**
     * Goes to the given URL.
     *
     * @param url - Site's URL.
     * @throws MalformedURLException Exception
     */
    private void goToURL(final String url) throws MalformedURLException {
        try {
            webDriver.navigate().to(new URL(url));
        } catch (MalformedURLException e) {
            log.error("Could not go to URL", e);
            throw e;
        }
    }

    /**
     * Gets the current URL.
     *
     * @return the URL.
     */
    public String getCurrentURL() {
        return webDriver
                .getCurrentUrl();
    }

    /**
     * Verifies if the current page is login.
     *
     * @return true if is in the login page.
     */
    public Boolean isOnLogin() {
        return (webDriver.getCurrentUrl().contains("login"));
    }

    /**
     * Verifies if the current page is without URL.
     *
     * @return true if is in the empty page.
     */
    public Boolean isOnEmptyPage() {
        return (webDriver.getCurrentUrl().contains("data:"));
    }

    /**
     * Navigates to Login Page.
     *
     * @return New instance of LoginPage.
     * @throws MalformedURLException Exception
     */
    public LoginPage navigateToLoginPage() throws MalformedURLException {
        goToURL(baseURL);
        return new LoginPage();
    }
}
