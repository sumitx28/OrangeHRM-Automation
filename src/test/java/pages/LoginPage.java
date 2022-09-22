package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By email=By.id("txtUsername");
    By password= By.id("txtPassword");
    By login=By.xpath("//div//button");
    public LoginPage(WebDriver driver) {
        this.driver= driver;
        System.out.println(driver.getTitle());

    }


    public DashboardPage login(String user, String pass) throws InterruptedException{
        driver.findElement(email).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(login).click();
        Thread.sleep(3000);
        return new DashboardPage(driver);


    }
}
