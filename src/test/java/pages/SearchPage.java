package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {

    WebDriver driver;
    By filterInputElement;
    By searchElement;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        filterInputElement = By.id("employee_name_quick_filter_employee_list_value");
        searchElement = By.xpath("//*[@id=\"ribbon-actions\"]/ui-view/ul/li[2]/a");
    }

    public void navigateToEmpPage(){
        EmployeeManagementPage emp = new EmployeeManagementPage(driver);
        emp.navigateToEmp();
    }

    public boolean searchEmp(String name , String location) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(filterInputElement).sendKeys(name);
        Thread.sleep(1000);
        driver.findElement(searchElement).click();
        Thread.sleep(2000);

        WebElement employeesTable = driver.findElement(By.id("employeeListTable"));
        List<WebElement> tableRows = employeesTable.findElements(By.tagName("tr"));

        for(int i=0; i<tableRows.size(); i++){
            WebElement row  = tableRows.get(i);

            System.out.println(row.getText().toString().substring(5) +  " Provided Data : " + name + " " + location);

            if(row.getText().toString().substring(5).equals(name + " " + location)){
                return true;
            }
        }

        return false;
    }

}
