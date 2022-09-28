package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Utility {
    WebDriver driver;
    By email;
    By password;
    By login;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver= driver;
        email = By.id("txtUsername");
        password = By.id("txtPassword");
        login = By.xpath("//div//button");
    }

    public void login(String user, String pass) throws InterruptedException{
        waitTillClickable(email);
        driver.findElement(email).sendKeys(user);
        waitTillClickable(password);
        driver.findElement(password).sendKeys(pass);
        waitAndClick(login);
    }

}
