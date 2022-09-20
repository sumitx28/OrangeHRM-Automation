package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.loginPage;

public class LoginTestCase extends BaseTest{
    loginPage obj;

    @Test(dataProvider="testData")
    public void loginTest(String info, String user, String pass) throws InterruptedException {
        obj=new loginPage(driver);
        System.out.println("Opening the browser");
        System.out.println(info);
        obj.login(user, pass);
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                { "Testing with invalid data","adminn", "addmin" },
                { "Testing with invalid data","as1939 ", " ad24" },
                { "Testing with valid data","Admin", "admin123" } };
    }
}