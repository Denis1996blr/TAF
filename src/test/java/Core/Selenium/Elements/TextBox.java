package Core.Selenium.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TextBox extends BaseElement {

    public TextBox(By locator) {
        super(locator);
    }

    public void clear()
    {
        waitElementIsVisible();
        element.clear();
    }

    public void type(String text)
    {
        waitElementIsVisible();
        element.sendKeys(text);
    }

    public void setTextPressEnter(String text)
    {
        clear();
        type(text);
        element.sendKeys(Keys.ENTER);
    }
}