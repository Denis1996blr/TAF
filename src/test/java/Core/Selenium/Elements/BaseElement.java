package Core.Selenium.Elements;

import Core.Selenium.BaseEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseElement extends BaseEntity {

    private final By locator;
    protected WebElement element;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }

    public WebElement getElement() {
        if (locator != null) {
            try {
                element = browser.driver.findElement(locator);
            } catch (Exception e) {
                return null;
            }
        }
        return element;
    }

    public Boolean isVisible() {
        try {
            return getElement().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean isEnabled() {
        waitElementIsVisible();
        return getElement().isEnabled();
    }

    public Boolean isPresent() {
        return getElement() != null;
    }

    public void click() {
        waitElementIsVisible();
        element.click();
    }

    public String getAttribute(String attr) {
        waitElementIsVisible();

        return element.getAttribute(attr);
    }

    public BaseElement waitElementIsVisible() {
        waitForCondition(expectedCondition -> isVisible(), String.format("Element with locator '%s' isn't visible.", this.locator));
        return this;
    }

    public BaseElement waitElementIsPresent() {
        waitForCondition(expectedCondition -> isPresent(), String.format("Element with locator '%s' isn't present.", this.locator));
        return this;
    }

    public BaseElement waitElementIsEnabled() {
        waitForCondition(expectedCondition -> isEnabled(), String.format("Element with locator '%s' isn't enabled.", this.locator));
        return this;
    }

    public String getText()
    {
        waitElementIsVisible();
        return getElement().getText();
    }
}