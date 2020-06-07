package Products.GoDev.Components.Pages;

import Core.Selenium.Elements.Element;
import Core.Selenium.Elements.TextBox;
import Core.Selenium.BaseEntity;
import org.openqa.selenium.By;

public class GoDevBasePage extends BaseEntity {

    public GoDevNavigationBar goDevNavigationBar = new GoDevNavigationBar();
    public TextBox searchInput = new TextBox(By.xpath("//form[@role='search']/input"));

    public GoDevBasePage(Element element){
        element.waitElementIsVisible();
    }

}