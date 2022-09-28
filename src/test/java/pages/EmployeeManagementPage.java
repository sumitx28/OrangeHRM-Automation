package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class EmployeeManagementPage {

    WebDriver driver;
    By employeeManagementButtonElement;
    By addEmployeeButtonElement;
    By firstNameElement;
    By middleNameElement;
    By lastNameElement;
    By locationElement;
    By saveButtonElement;
    By backButtonElement;
    By goBackButtonElement;
    By employeeFilterElement;
    By filterSearchButtonElement;
    HashMap<String , String> map;


    // Assigning the values for driver and elements.
    public EmployeeManagementPage(WebDriver driver) {
        this.driver = driver;
        employeeManagementButtonElement = By.id("menu_item_128");
        addEmployeeButtonElement = By.id("addEmployeeButton");
        firstNameElement = By.id("first-name-box");
        middleNameElement = By.id("middle-name-box");
        lastNameElement = By.id("last-name-box");
        locationElement = By.id("location");
        saveButtonElement = By.id("modal-save-button");
        backButtonElement = By.xpath("//*[@id=\"top-ribbon-menu\"]/div/div[2]/a");
        goBackButtonElement = By.xpath("//*[@id=\"ribbon-actions\"]/ui-view/ul/li[3]/a");
        employeeFilterElement = By.id("emp_search_mdl_employee_name_filter_value");
        filterSearchButtonElement = By.xpath("//*[@id=\"employee_list_search_modal\"]/div[2]/a[1]");

        map = new HashMap<>();

        map.put("France Office" , "string:41" );
        map.put("Germany Office" , "string:23");
        map.put("India Office" , "string:1");

    }

    // Navigate to the Employee Management Page
    public void navigateToEmp() {
        waitAndClick(employeeManagementButtonElement);
    }

    // Click on Add Employee + Button
    public void clickAddEmployee() {
        waitAndClick(addEmployeeButtonElement);
    }

    // Fill employee details -> First Name, Middle Name, Last Name and Location
    public void addEmployeeDetails(String firstName, String middleName, String lastName , String office) throws InterruptedException {
        waitAndClick(firstNameElement);
        waitAndClick(middleNameElement);
        waitAndClick(lastNameElement);
        driver.findElement(firstNameElement).sendKeys(firstName);
        driver.findElement(middleNameElement).sendKeys(middleName);
        driver.findElement(lastNameElement).sendKeys(lastName);

        Select se = new Select(driver.findElement(locationElement));
        se.selectByValue(map.get(office));

        waitAndClick(saveButtonElement);
        waitAndClick(backButtonElement);
    }

    // Clear default filters from the page
    public void clearFilters() throws InterruptedException {
        waitAndClick(goBackButtonElement);
        waitAndClick(employeeFilterElement);
        waitAndClick(filterSearchButtonElement);
    }

    // Verify that Employee has been added
    public Boolean verifyEmployee(String name , String location) throws InterruptedException {
        SearchPage search = new SearchPage(driver);
        return search.searchEmp(name , location);
    }

    public void waitAndClick(By element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

}
