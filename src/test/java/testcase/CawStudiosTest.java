package testcase;

import com.page.TestPage;
import com.setup.SeleniumSetup;
import org.testng.annotations.Test;

public class CawStudiosTest extends SeleniumSetup
{
    @Test(description = "land on the given url, you will have", priority = 1)
    public void get_url(){
        TestPage testPage = new TestPage(driver);
        testPage.getUrl();
    }
    @Test(description = "Click on Table Data button", priority = 2)
    public void click_on_table_data(){
        TestPage testPage = new TestPage(driver);
        testPage.clickTableData();
    }
    @Test(description = "Insert the data in input text box", priority = 3)
    public void insert_data_in_input_box(){
        TestPage testPage = new TestPage(driver);
        testPage.insert_data("src/main/resources/data.json");
    }
    @Test(description = "click on Refresh Table button.", priority = 4)
    public void refresh_table(){
        TestPage testPage = new TestPage(driver);
        testPage.refreshTable();
    }
    @Test(description = "assert the data you have stored with the data that is populated in the UI table.",priority = 5)
    public void assert_table_data(){
        TestPage testPage = new TestPage(driver);
        testPage.assertTableData();
    }

}
