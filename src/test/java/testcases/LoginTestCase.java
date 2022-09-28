package testcases;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTestCase extends BaseTest{
    LoginPage obj;

    // Before running login test case, Comment out login code from Base Test

    @DataProvider
    public static Object[][] credentials() {
        return new Object[][]{
                {"ABC" , "DEF"},
                {prop.getProperty("username") , prop.getProperty("password")}
        };
    }

    @Test(dataProvider = "credentials")
    public void loginTest(String username , String password) {
        obj=new LoginPage(driver);
        driver.get(prop.getProperty("websiteUrl"));

        test.log(Status.INFO , "Login Credentials: Username - " + username + " | Password - " + password);

        try{
            obj.login(username, password);
        }
        catch (Exception e){
            test.log(Status.FAIL , "Login Failed");
            Assert.fail("Login Failed");
        }

        String url=driver.getCurrentUrl();
        String curl= "https://sanjay29-trials76.orangehrmlive.com/client/#/dashboard";

        verifyCurrentUrl(curl);
        test.log(Status.PASS, "Login Success");

    }

}
