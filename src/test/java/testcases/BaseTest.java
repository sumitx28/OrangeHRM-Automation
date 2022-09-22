package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

public class BaseTest {

    public static WebDriver driver;
    LoginPage obj;

    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().window().maximize();
        driver.get("https://sanjay29-trials76.orangehrmlive.com/");
        Thread.sleep(5000);
        System.out.println("Url Loaded");

        obj=new LoginPage(driver);

        obj.login("Admin", "XwFwrZ28@Y");
        Thread.sleep(2000);

    }

}
