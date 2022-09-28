package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

    public void selectDropdown(String inputXpath , String ulXpath , String country) throws InterruptedException {

        driver.findElement(By.xpath(inputXpath)).click();

        Thread.sleep(2000);

        List<WebElement> opts = driver.findElements(By.xpath(ulXpath).tagName("li"));

        Thread.sleep(2000);

        for(WebElement elem : opts){
            if(elem.getText().toString().equals(country)){
                elem.click();
                break;
            }
        }

    }

    public void waitTillClickable(By element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
