package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocationPage {
  
	WebDriver driver;
	String inputxpath = "//*[@id=\"countryCode_inputfileddiv\"]/div/input";
	String ulxpath = "//*[@id=\"select-options-fa529d94-7a51-045f-5297-cd17602d11a7\"]";

	public LocationPage(WebDriver driver) {
		this.driver=driver;
	}

	public void fillDetails(String locName , String country) throws InterruptedException {

		// Fill Details
		driver.findElement(By.xpath("//i[@class=\"material-icons\"][text()=\"add\"]")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.id("name")).sendKeys(locName);
		driver.findElement(By.cssSelector("#city")).sendKeys("Surat");
		driver.findElement(By.cssSelector("#phone")).sendKeys("3452341120");
		driver.findElement(By.cssSelector("#zipCode")).sendKeys("395005");

		// Select Country From Dropdown
		selectDropdown(inputxpath , ulxpath , country);

		// Click Save
		driver.findElement(By.xpath("//*[@id=\"locationAddModal\"]/form/div[2]/a[1]")).click();


		System.out.println("Details Added to location page");

	}

	public void selectDropdown(String inputXpath , String ulXpath , String country) throws InterruptedException {

		driver.findElement(By.xpath(inputXpath)).click();

		Thread.sleep(2000);

		List<WebElement> opts = driver.findElements(By.xpath(ulXpath).tagName("li"));

		Thread.sleep(2000);

		for(WebElement elem : opts){
			if(elem.getText().toString().equals(country)){
				elem.click();
				break;
			}
		}

	}

}

