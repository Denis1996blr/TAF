package Products.GoDev.Components.Pages;

import Core.Selenium.Elements.Element;
import org.openqa.selenium.By;

public class MainPage extends GoDevBasePage {
    public MainPage() {
        super(new Element(By.xpath("//img[@class='Hero-gopherLadder']")));
    }
}