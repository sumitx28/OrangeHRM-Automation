package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static FileInputStream propInput;
    public static Properties prop;
    public static ExtentSparkReporter spark;
    public static ExtentReports extent;
    public static ExtentTest test;
    LoginPage obj;

    @BeforeTest
    public void before() {
        spark = new ExtentSparkReporter("ExtentSpark.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }
    @BeforeMethod
    public void beforeMethod(Method method) {
        test= extent.createTest(method.getName());
    }
    @BeforeClass
    public void setUp() throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        try{
            propInput= new FileInputStream("src/test/java/config/config,properties");
            prop= new Properties();
            prop.load(propInput);
        }
        catch (Exception e){
            test.log(Status.FAIL , "Failed to load config file. Check Path");
            driver.close();
        }

        driver.manage().window().maximize();
        driver.get(prop.getProperty("websiteUrl"));

        // Login to the page
//        obj = new LoginPage(driver);
//        obj.login(prop.getProperty("username"), prop.getProperty("password"));

    }

    @AfterTest
    public void after() {
        extent.flush();
    }

    @AfterClass
    public void close(){
        driver.close();
    }

    public void verifyCurrentUrl(String url) {

        if(!url.equals(driver.getCurrentUrl())){
            test.log(Status.FAIL,"Current URL:"
                    + driver.getCurrentUrl()+ " Expected URL: " + url);
            Assert.assertTrue(false);
        }
        else{
            test.log(Status.PASS,"Current URL:"
                    + driver.getCurrentUrl()+ " Expected URL: " + url);
        }

    }

}
