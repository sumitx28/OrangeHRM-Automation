package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
    WebDriver driver;

    public Utility(WebDriver driver){
        this.driver = driver;
    }

    public void waitAndClick(By element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }
}
