package testcases;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LocationPage;
import pages.LoginPage;
import java.util.List;

public class locationTestCase extends BaseTest {
	LoginPage objLogin;
	LocationPage objLocation;
	DashboardPage objDashboard;
	By tableElement = By.xpath("//*[@id=\"locationDiv\"]/crud-panel/div/div/list/table");

	@Test(dataProvider = "locData")
	public void addLocationTest(String locName , String pincode , String city , String phone , String country){
		objDashboard=new DashboardPage(driver);

		try{
			objDashboard.searchAndClick();
		} catch (Exception e) {
			test.log(Status.FAIL , "Click on search button failed with ERROR : " + e);
			Assert.fail("Failed Clicking on Search Button");
		}


		objLocation=new LocationPage(driver);

		try {
			test.log(Status.INFO , "Details : " + locName + " " + pincode + " " + city + " " + phone + " " + country);
			objLocation.fillDetails(locName , pincode , city , phone , country);
			test.log(Status.PASS , "Deatils Added Successfully");
		}
		catch (Exception e){
			test.log(Status.FAIL , "Failed to fill location details with error : " + e);
			Assert.fail("Failed to add location");
		}

	}

	@DataProvider
	public Object[][] locData(){
		return new Object[][] {
				{"AfgOfficcccccsnsee" , "1298" , "Kabul" , "9248562833" , "Afghanistan"}
		};
	}

	@Test(dataProvider = "locData")
	public void verifyLocationTest(String locName , String pincode , String city , String phone , String country){

		driver.get(prop.getProperty("locationsPageUrl"));
		test.log(Status.INFO , "Details : " + locName + " " + pincode + " " + city + " " + phone + " " + country);

		waitTillClickable(tableElement);
		WebElement table = driver.findElement(tableElement);
		List<WebElement> rows = table.findElements(By.tagName("span"));

		for(WebElement elem : rows){
			if(elem.getText().toString().equals(locName)){
				test.log(Status.PASS , "Location successfully Verified");
				return;
			}
		}

		test.log(Status.FAIL , "Failed to verify location");
		Assert.fail("Could not add location");
	}

}
