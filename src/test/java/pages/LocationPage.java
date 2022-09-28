package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocationPage extends Utility{
  
	WebDriver driver;
	By addButtonElement;
	By nameInputElement;
	By cityInputElement;
	By phoneInputElement;
	By zipInputElement;
	By saveButtonElement;

	String inputxpath , ulxpath;

	public LocationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		this.addButtonElement = By.xpath("//i[@class=\"material-icons\"][text()=\"add\"]");
		this.nameInputElement = By.id("name");
		this.cityInputElement = By.cssSelector("#city");
		this.phoneInputElement = By.cssSelector("#phone");
		this.zipInputElement = By.cssSelector("#zipCode");
		this.saveButtonElement = By.xpath("//*[@id=\"locationAddModal\"]/form/div[2]/a[1]");
		inputxpath = "//*[@id=\"countryCode_inputfileddiv\"]/div/input";
		ulxpath = "//*[@id=\"select-options-fa529d94-7a51-045f-5297-cd17602d11a7\"]";
	}

	public void fillDetails(String locName , String pincode , String city , String phone , String country) throws InterruptedException {

		// Fill Details
		waitAndClick(addButtonElement);
		waitAndClick(nameInputElement);
		driver.findElement(nameInputElement).sendKeys(locName);
		waitAndClick(zipInputElement);
		driver.findElement(zipInputElement).sendKeys(pincode);
		waitAndClick(cityInputElement);
		driver.findElement(cityInputElement).sendKeys(city);
		waitAndClick(phoneInputElement);
		driver.findElement(phoneInputElement).sendKeys(phone);

		// Select Country From Dropdown
		selectDropdown(inputxpath , ulxpath , country);

		// Click Save
		waitAndClick(saveButtonElement);

	}



}

