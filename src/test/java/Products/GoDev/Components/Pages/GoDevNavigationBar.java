package Products.GoDev.Components.Pages;

import Core.Selenium.Elements.Element;
import Core.Selenium.BaseEntity;
import org.openqa.selenium.By;

public class GoDevNavigationBar extends BaseEntity {

    protected final String headerMenuItem = "//ul[@class='Header-menu']//a[text()='%s']";

    public boolean isItemMenuVisible(String itemMenuTitle) {
        var itemMenuElement = new Element(By.xpath(String.format(headerMenuItem, itemMenuTitle)));
        return itemMenuElement.isVisible();
    }
}