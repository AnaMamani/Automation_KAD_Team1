package com.jalasoft.sfdc.ui;

import com.jalasoft.selenium.WebDriverManager;
import com.jalasoft.selenium.WebDriverTools;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * BasePage class.
 *
 * @author Silvia Valencia
 * @since 6/21/2018
 */
public abstract class BasePage {
    protected Logger log = Logger.getLogger(getClass());
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverTools driverTools;

    protected String parentWindowHandle;
    protected static final By SUCCESS_ALERT_MESSAGE_BY = By.cssSelector("div[class*='alert-success']");
    protected static final By LOADING_SPINNER_BY = By.cssSelector("div[id='phx-overlay-root']");
    protected static final By VIEWER_IFRAME_BY = By.className("Viewer-frame");

    /**
     * Initializes the web driver, wait, web driver tools and web elements.
     */
    public BasePage() {
        this.driver = WebDriverManager.getInstance().getWebDriver();
        this.wait = WebDriverManager.getInstance().getWait();
        this.driverTools = new WebDriverTools();
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    /**
     * Waits until page object is loaded.
     */
    public abstract void waitUntilPageObjectIsLoaded();

    /**
     * Verifies that a Success message is displayed.
     *
     * @return True if the Success message is displayed, false otherwise.
     */
    public boolean isSuccessMessageDisplayed() {
        return driverTools.waitUntilElementDisplayed(SUCCESS_ALERT_MESSAGE_BY);
    }

    /**
     * Waits until Spinner disappears.
     */
    protected void waitForSpinnerDisappears() {
        if (driverTools.isElementDisplayed(LOADING_SPINNER_BY)) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(LOADING_SPINNER_BY));
        }
    }

    /**
     * Switches to Viewer IFrame.
     */
    protected void switchToViewerIframe() {
        parentWindowHandle = driver.getWindowHandle();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(VIEWER_IFRAME_BY));
    }

    /**
     * Switches to parent window handle.
     */
    protected void switchToParentWindowHandle() {
        driver.switchTo().window(parentWindowHandle);
        /* The methods that use this method may need to call to the waitForSpinnerDisappears()
        after the call to this method. The spinner could be displayed after closing some popups. */
    }

    /**
     * Accepts and closes a javascript alert popup. Focus is then switched back to the page.
     */
    public void acceptAlertDialog() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
