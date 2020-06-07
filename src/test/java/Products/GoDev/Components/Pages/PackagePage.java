package Products.GoDev.Components.Pages;

import Core.Selenium.Elements.Element;
import org.openqa.selenium.By;

public class PackagePage extends GoDevBasePage {

    public Element PublishedInfo = new Element(By.xpath("//div[@class='DetailsHeader-infoLabel']/strong"));
    public Element LicensesInfo = new Element(By.xpath("//div[@class='DetailsHeader-infoLabel']/span[@data-test-id='DetailsHeader-infoLabelLicense']"));
    public Element ModuleInfo = new Element(By.xpath("//div[@class='DetailsHeader-infoLabel']//a[@data-test-id='DetailsHeader-infoLabelModule']"));
    private String detailsNavTabLocator = "//nav[contains(@class,'DetailsNav')]//a[normalize-space(text())='%s']";

    public PackagePage() {
        super(new Element(By.xpath("//header[@class='DetailsHeader']")));
    }

    public boolean isDetailsNavTabVisible(String detailsNavTabTitle) {
        var detailsNavTabElement = new Element(By.xpath(String.format(detailsNavTabLocator, detailsNavTabTitle)));
        return detailsNavTabElement.isVisible();
    }

}