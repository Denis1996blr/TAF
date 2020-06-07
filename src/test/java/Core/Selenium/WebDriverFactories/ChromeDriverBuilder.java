package Core.Selenium.WebDriverFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Objects;

public class ChromeDriverBuilder implements IWebDriverBuilder {

    //TODO: DA: need rework for possibility set browser capabilities
    @Override
    public WebDriver getDriver() {
        String pathToDriver = Objects.requireNonNull(getClass().getClassLoader().getResource("drivers/chromedriver.exe")).getPath();
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        return new ChromeDriver();
    }
}