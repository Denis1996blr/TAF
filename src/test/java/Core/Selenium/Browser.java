package Core.Selenium;

import Core.Selenium.WebDriverFactories.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Browser {

    public final WebDriver driver;

    public Browser(String browserName) {
        driver = WebDriverFactory.getInstance().getDriver(browserName);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public Boolean isPageLoaded()
    {
        var result = ((JavascriptExecutor) driver).executeScript("return document['readyState'] ? 'complete' == document.readyState : true");
        return result instanceof Boolean && (Boolean) result;
    }

    public void windowMaximise() {
        driver.manage().window().maximize();
    }

    public void navigateTo(String url)
    {
        driver.navigate().to(url);
    }

    public void closeBrowser()
    {
        driver.quit();
    }
}