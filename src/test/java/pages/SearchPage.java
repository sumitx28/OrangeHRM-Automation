package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;
import java.util.List;

public class SearchPage extends Utility {

    WebDriver driver;
    By filterInputElement;
    By searchElement;

    public SearchPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        filterInputElement = By.id("employee_name_quick_filter_employee_list_value");
        searchElement = By.xpath("//*[@id=\"ribbon-actions\"]/ui-view/ul/li[2]/a");
    }

    public void navigateToEmpPage(){
        EmployeeManagementPage emp = new EmployeeManagementPage(driver);
        emp.navigateToEmp();
    }

    public boolean searchEmp(String name , String location) throws InterruptedException {

        waitTillClickable(filterInputElement);
        driver.findElement(filterInputElement).sendKeys(name);
        waitTillClickable(searchElement);
        Thread.sleep(1000);
        driver.findElement(searchElement).click();
        waitTillClickable(By.id("employeeListTable"));

        WebElement employeesTable = driver.findElement(By.id("employeeListTable"));
        List<WebElement> tableRows = employeesTable.findElements(By.tagName("tr"));

        for(int i=0; i<tableRows.size(); i++){
            WebElement row  = tableRows.get(i);
            if(row.getText().toString().substring(5).equals(name + " " + location)){
                return true;
            }
        }

        return false;
    }

}
