package Core.Selenium;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;
import java.util.function.Function;

public abstract class BaseEntity {

    private static final String browserName;
    protected static Browser browser;
    private static final long timeout;

    static {
        var appProperty = new Properties();
        var propertiesFile = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
        try {
            appProperty.load(propertiesFile);
        } catch (IOException e) {
            e.printStackTrace(new PrintWriter(new StringWriter().append("Props file 'config.properties' doesn't find by path")));
        }
        browserName = appProperty.getProperty("browser");
        timeout = Long.parseLong(appProperty.getProperty("element_timeout"));
        browser = new Browser(browserName);
    }

    public String getBrowserName() {
        return browserName;
    }

    public void waitForCondition(Function<WebDriver, Boolean> condition, String failMessage) {
        try {
            new WebDriverWait(browser.driver, timeout).until(condition);
        } catch (Exception e) {
            throw new ElementNotVisibleException(String.format("After '%d' second '%s'", timeout, failMessage));
        }
    }
}