package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    By createNewButton = By.xpath("//span[@class='create-resource-popup-with-anchor']//button");
    By createNewFolder = By.xpath("//span[contains(@class,'file-icon_dir_plus')]");
    By inputFolderName = By.xpath("//div[@class='modal__content']//input[@class='textinput__control']");
    By confirmButton = By.xpath("//button[contains(@class,'confirmation-dialog__button')]");
    By modal = By.xpath("//div[contains(@class,'modal')]");

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

    public WebElement getCreateNewButton() {
        return webDriver.findElement(createNewButton);
    }

    public WebElement getCreateNewFolder() {
        return webDriver.findElement(createNewFolder);
    }

    public WebElement getInputFolderName() {
        return webDriver.findElement(inputFolderName);
    }

    public WebElement getConfirmButton() {
        return webDriver.findElement(confirmButton);
    }

    public WebElement getModal() {
        return webDriver.findElement(modal);
    }

    public void createNewFolder(String folderName) {
        getCreateNewButton().click();
        getCreateNewFolder().click();
        wait.until(ExpectedConditions.elementToBeClickable(getInputFolderName())).click();
        getInputFolderName().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        getInputFolderName().sendKeys(Keys.DELETE);
        wait.until(ExpectedConditions.attributeToBe(getInputFolderName(), "value", ""));
        getInputFolderName().sendKeys(folderName);
        getConfirmButton().click();
        wait.until(ExpectedConditions.invisibilityOf(getModal()));
        wait.until(ExpectedConditions.elementToBeClickable(getCreatedFolder(folderName)));
    }

//    public WebElement getCreatedFolder (String folderName) {
//        return webDriver.findElement(By.xpath("//span[contains(text(),'"+folderName+"')]"));
//    }

    public WebElement getCreatedFolder(String folderName) {
        return webDriver.findElement(By.xpath("//span[contains(text(),'"+folderName+"')]//preceding::div[contains(@class,'listing-item__icon_resource_dir')]"));
    }
}
