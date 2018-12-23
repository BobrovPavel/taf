package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DiskPage extends Base {


    By recentTab = By.xpath("//a[@href='/client/recent']");
    By fileTab = By.xpath("//a[@href='/client/disk']");
    By photoTab = By.xpath("//a[@href='/client/photo']");
    By sharedTab = By.xpath("//a[@href='/client/shared']");
    By historyTab = By.xpath("//a[@href='/client/journal']");
    By archiveTab = By.xpath("//a[@href='/client/mail']");
    By trashTab = By.xpath("//a[@href='/client/trash']");
    By rootListing = By.xpath("//div[@class='root__listing']");
    By rootListingTitle = By.xpath("//h1");

    public DiskPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDiskTab (String tabName) {
        return webDriver.findElement(By.xpath("//a[@href='/client/"+tabName+"']"));
    }

    public WebElement getRecentTab() {
        return webDriver.findElement(recentTab);
    }

    public WebElement getFileTab() {
        return webDriver.findElement(fileTab);
    }

    public WebElement getPhotoTab() {
        return webDriver.findElement(photoTab);
    }

    public WebElement getSharedTab() {
        return webDriver.findElement(sharedTab);
    }

    public WebElement getHistoryTab() {
        return webDriver.findElement(historyTab);
    }

    public WebElement getArchiveTab() {
        return webDriver.findElement(archiveTab);
    }

    public WebElement getTrashTab() {
        return webDriver.findElement(trashTab);
    }

    public WebElement getRootListing() {
        return webDriver.findElement(rootListing);
    }

    public WebElement getRootListingTitle() {
        return webDriver.findElement(rootListingTitle);
    }
}
