package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LocationPage;
import pages.LoginPage;

import java.util.List;


public class locationTestCase extends BaseTest {
	LoginPage objLogin;
	LocationPage objLocation;
	DashboardPage objDashboard;

	String locName = "India Office";
	String country = "India";

	@Test()
	public void addLocation() throws InterruptedException {
		objDashboard=new DashboardPage(driver);
		objDashboard.searchAndClick();

		objLocation=new LocationPage(driver);
		objLocation.fillDetails(locName , country);

	}

	@Test
	public void verifyLocation(){
		WebElement table = driver.findElement(By.xpath("//*[@id=\"locationDiv\"]/crud-panel/div/div/list/table"));

		List<WebElement> rows = table.findElements(By.tagName("span"));

		for(WebElement elem : rows){
			if(elem.getText().toString().equals(locName)){
				return;
			}
		}

		Assert.fail("Could not add location");

	}

}
