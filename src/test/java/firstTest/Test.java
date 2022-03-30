package firstTest;

import core.BrowserService;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class Test {

    public BrowserService driver;

    @BeforeMethod(alwaysRun = true)
    public void startBrowser(ITestContext testContext) throws MalformedURLException {
        driver = new BrowserService();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.getDriver().quit();
    }

    @org.testng.annotations.Test
    public void test() {
        driver.getDriver().get("https://www.google.com/");
        String title = driver.getDriver().getTitle();
        Assert.assertEquals(title, "Google");
    }
}