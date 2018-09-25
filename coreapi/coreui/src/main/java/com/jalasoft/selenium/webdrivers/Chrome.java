package com.jalasoft.selenium.webdrivers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

/**
 * Created by Silvia Valencia on 2/2/2018.
 * Handles Chrome driver initialization.
 */
class Chrome implements IDriver {
    /**
     * Initializes Chrome driver.
     *
     * @return A new ChromeDriver.
     */
    @Override
    public WebDriver initDriver() {
        ChromeDriverManager.getInstance().setup();

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);

        //Boolean to specify if ask the user to download a file (true) or  download automatically (false)
        chromePrefs.put("download.prompt_for_download", "false");

        //String to specify where to download files to by default.
//        chromePrefs.put("download.default_directory", file.getAbsolutePath());

        ChromeOptions chromeOptions = new ChromeOptions();

        // Passing the disable-infobars ChromeOption to the WebDriver,
        // prevents Chrome from displaying this notification.
        // Chrome is being controlled by automated test software
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        return new ChromeDriver(chromeOptions);
    }


}
