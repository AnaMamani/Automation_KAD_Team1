package com.jalasoft.sfdc.ui;

import com.jalasoft.selenium.WebDriverManager;
import com.jalasoft.sfdc.config.ServersConfigReader;
import com.jalasoft.sfdc.constants.SFDCEnums;
import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.pages.LoginPage;
import com.jalasoft.sfdc.ui.pages.account.AccountDetailPage;
import com.jalasoft.sfdc.ui.pages.product.ProductDetailPage;
import org.apache.log4j.Logger;
import org.apache.regexp.RE;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.jalasoft.sfdc.constants.SFDCConstants.*;

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
    private static SFDCEnums.Skin skin = ServersConfigReader.getInstance().getSkin();
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

    /**
     * Navigates to ProductDetail Page.
     * @param product product.
     * @return new page of ProductDetail.
     * @throws MalformedURLException
     */
    public ProductDetailPage navigateToProductPage(Product product) throws MalformedURLException {
        log.info("navigateToProductPage ====> go to page details");
        System.out.println(product.getId());
        switch (skin) {
            case CLASSIC:
                log.debug("navigateToProductClassic ====> go to page details");
                goToURL(URL_PRODUCT_CLASSIC.concat(product.getId()));
                return PageFactory.getProductDetailPage();
            default:
                log.debug("navigateToProductPageLight ====> go to page details");
                goToURL(URL_PRODUCT_LIGHT.concat(product.getId()).concat(VIEW));
                return PageFactory.getProductDetailPage();
        }

    }

    public AccountDetailPage navigateToAcountPage(Account account) throws MalformedURLException{
        System.out.println(account.getId());
        switch (skin) {
            case CLASSIC:
                goToURL(URL_ACCOUNT_CLASSIC.concat(account.getId()));
                return PageFactory.getAccountDetailPage();

            default:
                goToURL(URL_ACCOUNT_LIGHT.concat(account.getId()).concat(VIEW));
                return PageFactory.getAccountDetailPage();
        }
    }
}
