package testcases;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EmployeeManagementPage;

import java.util.List;

public class EmployeeManagementTestCase extends BaseTest{

    // Test - 1 : Navigating to the Employee Management Page
    @Test()
    public void navigateToEmployeeManagementPage(){
        EmployeeManagementPage emp = new EmployeeManagementPage(driver);
        emp.navigateToEmp();

        // Assertion and Extent Report for Navigation
        super.verifyCurrentUrl(prop.getProperty("expectedUrlManagementPage"));
    }

    // Test - 2 : Add Employee details and Verify the added employee
    @Test(priority = 1 , dataProvider = "testData" , dependsOnMethods = "navigateToEmployeeManagementPage")
    public void fillAndValidateEmployeeDetails(String firstName , String middleName , String lastName , String location) throws InterruptedException {
        EmployeeManagementPage emp = new EmployeeManagementPage(driver);
        emp.navigateToEmp();
        // Assertion and Report for clickAddEmployee Button
        try{
            emp.clickAddEmployee();
            test.log(Status.PASS , "Add employee button clicked successfully");
        }catch (Exception e){
            test.log(Status.FAIL , "Add Employee Button click FAILED with error : \n" + e);
            Assert.fail("Add employee button click failed");
        }

        test.log(Status.INFO , "Test Details : " + "Name : " + firstName + " " + middleName + " " + lastName + " ,  " + "Office : " + location);

        // Assertion and Report for Filling and Saving Employee Details
        try{
            emp.addEmployeeDetails(firstName , middleName , lastName , location);
            test.log(Status.PASS , "Employee details added successfully");
        }catch (Exception e){
            test.log(Status.FAIL , "Adding Employee Details FAILED with error : " + e);
            Assert.fail("Adding Employee failed");
        }

        // Assertion and Report for Verifying the employee after saving all the details.
        try{
            Boolean searchRes = emp.verifyEmployee(firstName + " " + middleName + " " + lastName , location);
            if(searchRes){
                test.log(Status.PASS , "Employee Verified. Add Successful");
            }
            else{
                test.log(Status.FAIL , "Could not find employee using search");
                Assert.fail("Could not find employee using search");
            }
        }catch (Exception e){
            test.log(Status.FAIL , "Failed to verify Employee  NAME : " +firstName + " " + middleName + " " + lastName + "STATUS : " + e);
            Assert.fail("Failed to verify employee");
        }


    }

    // Data Provider for AddEmployeeDetails Test
    @DataProvider
    public Object[][] testData(){
        return new Object[][] {
                {"Sam" , "T" , "Patel" , "India Office"}
        };
    }

    // Test - 3 : Test to clear all filters and see all the employees
    @Test(priority = 2 , dependsOnMethods = "fillAndValidateEmployeeDetails")
    public void clearFiltersTest(){
        EmployeeManagementPage emp = new EmployeeManagementPage(driver);
        try{
            emp.clearFilters();
            test.log(Status.PASS , "Successfully Cleared filters on Employee Page");
        }catch (Exception e){
            test.log(Status.FAIL , "Error showing employee details after adding. ERROR : " + e);
            Assert.fail("Failed to clear filters");
        }
    }

}
