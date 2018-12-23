package Tests;

import Commons.Constants;
import Pages.Base;
import org.testng.Assert;
import org.testng.annotations.*;


public class MenuItemsTests extends Configuration {

    @DataProvider
    public Object[][] driveTabs() {
        return new Object[][] {
                {"recent", "recent"},
                {"disk", "disk"},
                {"photo", "photo"},
                {"journal", "journal"},
                {"mail", "mail"},
                {"trash", "trash"},
        };
    }

    @BeforeClass
    public void setupClass() {
        setUp();
        webDriver.get("https://disk.yandex.ru/");
        site.loginPage().login();
    }

    @BeforeMethod
    public void beforeTest() {
        System.out.println(webDriver.getCurrentUrl());
    }

    @Test (dataProvider = "driveTabs")
    public void checkDriveTabs(String tabName, String urlName) {
        Base.waitAndClick(site.diskPage().getDiskTab(tabName));
        Assert.assertEquals(webDriver.getCurrentUrl(), Constants.getUriveTabsUrl(urlName));
    }

    @Test
    public void sharedTabTest() {
        Base.waitAndClick(site.diskPage().getSharedTab());
        Assert.assertTrue((webDriver.getCurrentUrl().equals(Constants.PUBLISHED_TAB_URL) || (webDriver.getCurrentUrl().equals(Constants.SHARED_TAB_URL))));
    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }
}
