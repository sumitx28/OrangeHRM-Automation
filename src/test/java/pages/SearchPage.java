package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToEmpPage(){
        EmployeeManagementPage emp = new EmployeeManagementPage(driver);
        emp.navigateToEmp();
    }

    public void searchEmp(String name) throws InterruptedException {


        driver.findElement(By.id("employee_name_quick_filter_employee_list_value")).sendKeys("Vansh Bansal");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"ribbon-actions\"]/ui-view/ul/li[2]/a")).click();

    }



}
