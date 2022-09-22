package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeeManagementPage;

public class EmployeeManagementTestCase extends BaseTest{



    @Test(priority = 0)
    public void navigateTest(){
        EmployeeManagementPage emp = new EmployeeManagementPage(driver);
        emp.navigateToEmp();

        String expectedUrl = "https://sanjay29-trials76.orangehrmlive.com/client/#/pim/employees";

        if(!expectedUrl.equals(driver.getCurrentUrl().toString())){
            Assert.fail("Error navigating to employee management page");
        }
        else{
            System.out.println("Success");
        }

    }

    @Test(priority = 1)
    public void addEmployeeDetailsTest() throws InterruptedException {

        EmployeeManagementPage emp = new EmployeeManagementPage(driver);
        Thread.sleep(5000);
        emp.clickAddEmployee();
        System.out.println("Click on Add Employee button Successful");

    }

    @Test(priority = 2)
    public void fillDetailsTest() throws InterruptedException {
        EmployeeManagementPage emp = new EmployeeManagementPage(driver);
        Thread.sleep(4000);
        emp.addEmployeeDetails("ABC" , "DEF" , "GHI");

        Thread.sleep(5000);

        showEmployees();

    }


    public void showEmployees() throws InterruptedException {
        EmployeeManagementPage emp = new EmployeeManagementPage(driver);
        emp.showEmployees();
    }


}
