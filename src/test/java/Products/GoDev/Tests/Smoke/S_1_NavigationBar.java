package Products.GoDev.Tests.Smoke;

import Products.GoDev.Components.Pages.MainPage;
import Products.GoDev.Tests.GoDevBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S_1_NavigationBar extends GoDevBaseTest {

    @Test
    public void S_1_NavigationBarTest() {

        var whyGoNavigationMenuItem = "Why Go";
        var gettingStartedNavigationMenuItem = "Getting Started";
        var discoverPackagesNavigationMenuItem = "Discover Packages";
        var aboutNavigationMenuItem = "About";

        //2
        var mainPage = new MainPage();
        Assert.assertTrue(mainPage.goDevNavigationBar.isItemMenuVisible(whyGoNavigationMenuItem), String.format("Menu item '%s' isn't visible.", whyGoNavigationMenuItem));
        Assert.assertTrue(mainPage.goDevNavigationBar.isItemMenuVisible(gettingStartedNavigationMenuItem), String.format("Menu item '%s' isn't visible.", gettingStartedNavigationMenuItem));
        Assert.assertTrue(mainPage.goDevNavigationBar.isItemMenuVisible(discoverPackagesNavigationMenuItem), String.format("Menu item '%s' isn't visible.", discoverPackagesNavigationMenuItem));
        Assert.assertTrue(mainPage.goDevNavigationBar.isItemMenuVisible(aboutNavigationMenuItem), String.format("Menu item '%s' isn't visible.", aboutNavigationMenuItem));
    }
}