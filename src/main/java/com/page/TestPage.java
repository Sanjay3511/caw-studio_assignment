package com.page;

import com.setup.SeleniumActions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestPage extends SeleniumActions {
    @FindBy(xpath = "//summary[text()='Table Data']")
    WebElement button_table_data;
    @FindBy(id = "refreshtable")
    WebElement button_refresh_table;
    @FindBy(id = "jsondata")
    WebElement input_text_area;

    public TestPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void getUrl(){
        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
    }
    public void clickTableData(){
            button_table_data.click();
    }
    public void refreshTable(){
        waitForElement(button_refresh_table);
        button_refresh_table.click();
    }
    public void insert_data(String path){
        waitForElement(input_text_area);
        input_text_area.clear();
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(path)));
            input_text_area.sendKeys(jsonData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void assertTableData() {
        try {
            // Read JSON data from the file
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("src/main/resources/data.json"));

            // Verify table heading
            WebElement table = driver.findElement(By.id("dynamictable"));
            WebElement caption = table.findElement(By.tagName("caption"));
            if (!caption.getText().trim().equals("Dynamic Table")) {
                throw new AssertionError("Table heading 'Dynamic Table' not found.");
            }
            System.out.println("Table heading 'Dynamic Table' found.");

            // Get all table rows excluding the header row
            List<WebElement> rows = table.findElements(By.xpath(".//tr[not(th)]"));

            // Iterate over each row in JSON array
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                WebElement row = rows.get(i);

                // Print JSON data for the current row
                System.out.println("Expected JSON data for row " + (i + 1) + ": " + jsonObject.toJSONString());

                // Iterate over each cell in JSON object
                for (Object key : jsonObject.keySet()) {
                    String expectedValue = jsonObject.get(key).toString();
                    boolean found = false;

                    // Iterate over each cell in the table row
                    List<WebElement> cells = row.findElements(By.tagName("td"));
                    for (WebElement cell : cells) {
                        if (cell.getText().equals(expectedValue)) {
                            found = true;
                            System.out.println("Value '" + expectedValue + "' found in row " + (i + 1));
                            break;
                        }
                    }

                    // Print assertion result for each cell
                    if (!found) {
                        System.out.println("Value '" + expectedValue + "' not found in row " + (i + 1));
                        throw new AssertionError("Expected value '" + expectedValue + "' not found in row " + (i + 1));
                    }
                }
                System.out.println("Row " + (i + 1) + " assertion successful.");
            }
            System.out.println("All assertions successful.");
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while asserting table data: " + e.getMessage());
        }
    }




}
