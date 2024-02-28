package com.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SeleniumUtils {
    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")+"//test-output//screen-shot//"+testCaseName+".png";
        String destinationFile = System.getProperty("user.dir")+"//test-output//screen-shot//"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
        System.out.println(destinationFile);
        return destinationFile;
    }

}
