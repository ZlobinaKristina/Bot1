import core.BrowserService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Main {
    @Test
    public static void main(String[] args) throws MalformedURLException {
        BrowserService driver = new BrowserService();
        driver.getDriver().get("https://www.google.com/");
        String title = driver.getDriver().getTitle();
        Assert.assertEquals(title, "Google");
    }
}
