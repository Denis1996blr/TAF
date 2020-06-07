package Core.Selenium.WebDriverFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Objects;

public class FirefoxDriverBuilder implements IWebDriverBuilder {

    //TODO: DA: need rework for possibility set browser capabilities
    @Override
    public WebDriver getDriver() {
        String pathToDriver = Objects.requireNonNull(getClass().getClassLoader().getResource("drivers/geckodriver.exe")).getPath();
        System.setProperty("webdriver.gecko.driver", pathToDriver);
        return new FirefoxDriver();
    }
}