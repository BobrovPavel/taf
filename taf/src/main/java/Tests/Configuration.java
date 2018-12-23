package Tests;

import Commons.Site;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Configuration {

    public WebDriver webDriver;
    public WebDriverWait wait;
    public Site site;
    SoftAssert softAssert;

    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        // т.к. Ubuntu немного иначе работает с относительными путями
//        System.setProperty("webdriver.chrome.driver", "/home/pasha/IdeaProjects/taf/src/main/resources/drivers/chromedriver");
        webDriver = new ChromeDriver();
        softAssert = new SoftAssert();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver,10,500);
        site = new Site(webDriver);
    }
}
