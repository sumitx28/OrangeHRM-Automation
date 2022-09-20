package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public static WebDriver driver;
    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://sanjay29-trials76.orangehrmlive.com/auth/login/");
        Thread.sleep(5000);
        System.out.println("opened");

    }

    @AfterClass
    public void close() {
        driver.close();
    }
}
