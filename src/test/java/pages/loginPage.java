package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

    WebDriver driver;

    By email=By.name("txtUsername");
    By password= By.name("txtPassword");
    By login = By.cssSelector("#divLogin > div.login-form-container > div > form > div.button-holder > button");

    public loginPage(WebDriver driver) {
        this.driver= driver;
        System.out.println(driver.getTitle());
    }


    public void login(String user, String pass) throws InterruptedException{
        driver.findElement(email).sendKeys(user);
        Thread.sleep(2000);

        driver.findElement(password).sendKeys(pass);
        Thread.sleep(2000);
        driver.findElement(login).click();
        Thread.sleep(5000);

    }
}
