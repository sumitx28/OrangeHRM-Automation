package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        waitAndClick(email);
        driver.findElement(email).sendKeys(user);
        waitAndClick(password);
        driver.findElement(password).sendKeys(pass);
        waitAndClick(login);
    }

}
