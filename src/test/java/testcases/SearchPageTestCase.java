package testcases;

import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchPageTestCase extends BaseTest {
    SearchPage sp;

    @Test(priority = 0)
    public void navigateToSearchPage() throws InterruptedException {
        sp = new SearchPage(driver);
        sp.navigateToEmpPage();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void SearchTest() throws InterruptedException {
        sp = new SearchPage(driver);
        sp.searchEmp("Vansh Bansal");
    }

}
