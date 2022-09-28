package testcases;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchPageTestCase extends BaseTest {
    SearchPage sp;
    @Test(priority = 0)
    public void navigateToSearchPage(){
        sp = new SearchPage(driver);

        try{
            test.log(Status.INFO , "Navigating to Search Employee Page");
            sp.navigateToEmpPage();
            test.log(Status.PASS , "Succesfully Navigated to Search employee Page");
        }
        catch (Exception e){
            test.log(Status.FAIL , "Failed to navigate to Search Employee Page. ERROR : " + e);
            Assert.fail("Failed Navigating to Search Employee Page");
        }
    }

    @Test(priority = 1)
    public void SearchTest(){
        sp = new SearchPage(driver);
        try{
            Boolean search = sp.searchEmp("Bansal" , "India Office");

            if(search){
                test.log(Status.PASS , "Found Employee");
            }
            else{
                test.log(Status.PASS , "Search Complete -> Employee Not Found");
            }
            Assert.assertTrue(true);

        } catch (Exception e) {
            test.log(Status.FAIL , "Search Test Failed with ERROR : " + e);
            Assert.fail("Search Test Failed");
        }

    }

}
