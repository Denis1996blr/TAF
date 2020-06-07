package Products.GoDev.Tests;

import Core.Selenium.BaseEntity;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class GoDevBaseTest extends BaseEntity {

    @BeforeTest
    public void InitTest() {
        browser.windowMaximise();
        browser.navigateTo("https://go.dev/");
    }

    @AfterTest
    public void DisposeTest() {
        browser.closeBrowser();
    }
}