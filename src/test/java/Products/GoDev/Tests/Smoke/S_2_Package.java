package Products.GoDev.Tests.Smoke;

import Products.GoDev.Components.Pages.MainPage;
import Products.GoDev.Components.Pages.PackagePage;
import Products.GoDev.Components.Pages.ResultsPage;
import Products.GoDev.Tests.GoDevBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S_2_Package extends GoDevBaseTest {

    @Test
    public void S_2_PackageTest() {

        var DocDetailsNavTab = "Doc";
        var DetailsNavTabOverview = "Overview";
        var DetailsNavTabSubdirectories = "Subdirectories";
        var DetailsNavTabVersions = "Versions";
        var DetailsNavTabImports = "Imports";
        var DetailsNavTabImportedBy = "Imported By";
        var DetailsNavTabLicenses = "Licenses";
        var protocGenSetterPackageName = "github.com/mikekonan/protoc-gen-setter";

        //2
        var mainPage = new MainPage();
        mainPage.searchInput.setTextPressEnter("setter");

        //3
        var resultsPage = new ResultsPage();
        resultsPage.NavigateToPage(5);

        //4
        resultsPage.selectPackage(protocGenSetterPackageName);

        //5
        var packagePage = new PackagePage();
        Assert.assertTrue(packagePage.isDetailsNavTabVisible(DocDetailsNavTab), String.format("Nav tab item '%s' isn't visible.", DocDetailsNavTab));
        Assert.assertTrue(packagePage.isDetailsNavTabVisible(DetailsNavTabOverview), String.format("Nav tab item '%s' isn't visible.", DetailsNavTabOverview));
        Assert.assertTrue(packagePage.isDetailsNavTabVisible(DetailsNavTabSubdirectories), String.format("Nav tab item '%s' isn't visible.", DetailsNavTabSubdirectories));
        Assert.assertTrue(packagePage.isDetailsNavTabVisible(DetailsNavTabVersions), String.format("Nav tab item '%s' isn't visible.", DetailsNavTabVersions));
        Assert.assertTrue(packagePage.isDetailsNavTabVisible(DetailsNavTabImports), String.format("Nav tab item '%s' isn't visible.", DetailsNavTabImports));
        Assert.assertTrue(packagePage.isDetailsNavTabVisible(DetailsNavTabImportedBy), String.format("Nav tab item '%s' isn't visible.", DetailsNavTabImportedBy));
        Assert.assertTrue(packagePage.isDetailsNavTabVisible(DetailsNavTabLicenses), String.format("Nav tab item '%s' isn't visible.", DetailsNavTabLicenses));

        //6
        Assert.assertEquals(packagePage.PublishedInfo.getText(), "Apr 13, 2020", "Published info doesn't equal expected.");
        Assert.assertEquals(packagePage.LicensesInfo.getText(), "None detected not legal advice", "Licenses info doesn't equal expected.");
        Assert.assertEquals(packagePage.ModuleInfo.getText(), protocGenSetterPackageName, "Module info doesn't equal expected.");
    }
}