package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DashboardPage {
    WebDriver driver;
    By search= By.xpath("//input[@id=\"menuQuickSearch_menuQuickSearch\"]");
    By searchText= By.xpath("//div[@class=\"menu-title\"][text()=\"Locations\"]");

    public DashboardPage(WebDriver driver) {
        this.driver=driver;
    }

    public void searchAndClick() throws InterruptedException {
        driver.findElement(search).sendKeys("Locations");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(searchText).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
}
