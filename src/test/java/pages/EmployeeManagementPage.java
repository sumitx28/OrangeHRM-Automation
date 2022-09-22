package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class EmployeeManagementPage {

    WebDriver driver;

    public EmployeeManagementPage(WebDriver driver){
        this.driver = driver;
    }


    public void navigateToEmp(){
        driver.findElement(By.id("menu_item_128")).click();
    }

    public void clickAddEmployee(){
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/section/div[3]/ui-view/div[1]/div/div/div/div/a")).click();

        WebElement element = driver.findElement(By.id("addEmployeeButton"));

        Actions actions = new Actions(driver);

        actions.moveToElement(element).click().perform();

    }

    public void addEmployeeDetails(String fname , String mname , String lname) throws InterruptedException {
        driver.findElement(By.id("first-name-box")).sendKeys(fname);
        driver.findElement(By.id("middle-name-box")).sendKeys(mname);
        driver.findElement(By.id("last-name-box")).sendKeys(lname);

        Select se = new Select(driver.findElement(By.id("location")));

        se.selectByValue("string:1");

        Thread.sleep(2000);

        driver.findElement(By.id("modal-save-button")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"top-ribbon-menu\"]/div/div[2]/a")).click();

        System.out.println("Employee Added Successfully");


    }

    public void showEmployees() throws InterruptedException {
        Thread.sleep(4000);

        driver.findElement(By.xpath("//*[@id=\"ribbon-actions\"]/ui-view/ul/li[3]/a")).click();

        Thread.sleep(2000);

        driver.findElement(By.id("emp_search_mdl_employee_name_filter_value")).clear();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"employee_list_search_modal\"]/div[2]/a[1]")).click();

    }

}
