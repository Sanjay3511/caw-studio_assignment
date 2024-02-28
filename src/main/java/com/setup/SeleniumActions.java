package com.setup;

import com.utils.SeleniumUtils;
import dev.failsafe.internal.util.Durations;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class SeleniumActions extends SeleniumUtils {
    public WebDriver driver;

    public SeleniumActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void waitForElement(WebElement element){
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }


}
