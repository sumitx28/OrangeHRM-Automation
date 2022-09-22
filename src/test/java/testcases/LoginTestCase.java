package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTestCase extends BaseTest{
    LoginPage obj;

    @Test
    public void loginTest() throws InterruptedException {
        obj=new LoginPage(driver);
        System.out.println("Opening the browser");

        obj.login("Admin", "XwFwrZ28@Y");
        String url=driver.getCurrentUrl();
        String curl= "https://sanjay29-trials76.orangehrmlive.com/client/#/dashboard";
        Assert.assertEquals(curl,url, "passed");
        System.out.println("the end.validated");


    }
}
