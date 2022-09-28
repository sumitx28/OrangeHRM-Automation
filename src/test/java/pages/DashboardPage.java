package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class DashboardPage extends Utility {
    WebDriver driver;
    By search;
    By searchText;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.search = By.xpath("//input[@id=\"menuQuickSearch_menuQuickSearch\"]");
        this.searchText = By.xpath("//div[@class=\"menu-title\"][text()=\"Locations\"]");
    }

    public void searchAndClick() throws InterruptedException {
        waitAndClick(search);
        driver.findElement(search).sendKeys("Locations");
        waitAndClick(searchText);
    }
}
