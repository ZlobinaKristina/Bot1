package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigCache;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class BrowserService {
    private WebDriver driver;

    public BrowserService() throws MalformedURLException {
        GeneralConfig generalConfig = ConfigCache.getOrCreate(GeneralConfig.class);
        switch (generalConfig.browser().toLowerCase()) {
            case "chrome":
                WebDriverManager.getInstance(CHROME).setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("--silent");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().timeouts().implicitlyWait(generalConfig.timeout(), TimeUnit.SECONDS);
                break;
            case "remote_chrome":
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", "chrome");
                driver = new RemoteWebDriver(new URL("http://139.162.239.131:8080/"), capabilities);
                driver.manage().window().setSize(new Dimension(1920, 1080));
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}