package Core.Selenium.WebDriverFactories;

import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {

    private static WebDriverFactory instance;

    //TODO: DA: Need rewrite if we wanna run tests in parallel
    public static synchronized WebDriverFactory getInstance() {
        if (instance == null) {
            instance = new WebDriverFactory();
        }
        return instance;
    }

    private final Map<String, IWebDriverBuilder> BrowserMap = new HashMap<>() {
        {
            put("Chrome", new ChromeDriverBuilder());
            put("Firefox", new FirefoxDriverBuilder());
        }
    };

    public synchronized WebDriver getDriver(String browserName) {
        return BrowserMap.get(browserName).getDriver();
    }
}