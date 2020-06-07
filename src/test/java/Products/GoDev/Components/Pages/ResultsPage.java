package Products.GoDev.Components.Pages;

import Core.Selenium.Elements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class ResultsPage extends GoDevBasePage {

    private final String paginationNumberLocator = "//div[contains(@class,'resultCount')]//div[@class='Pagination-nav']//*[@class='Pagination-number' and text()='%s']";
    private final String packageLocator = "//div[@class='SearchSnippet']//a[@href='/%s']";
    private Element currentPageNumberElement = new Element(By.xpath("//div[@class='Pagination-nav']//b"));

    public ResultsPage() {
        super(new Element(By.xpath("//div[@class='SearchResults']")));
    }

    public void NavigateToPage(int pageNumber) {
        var currentPageNumber = Integer.parseInt(currentPageNumberElement.getText());
        if (currentPageNumber == pageNumber) return;

        var paginationNumberElement = new Element(By.xpath(String.format(paginationNumberLocator, pageNumber)));
        paginationNumberElement.click();
        waitForCondition(x -> paginationNumberElement.getAttribute("href") == null, String.format("Navigation to page #%d finished incorrect.", pageNumber));
    }

    public void selectPackage(String packageName) {
        var packageElement = new Element(By.xpath(String.format(packageLocator, packageName))).getElement();
        new Actions(browser.driver).moveToElement(packageElement).click(packageElement).build().perform();
    }
}