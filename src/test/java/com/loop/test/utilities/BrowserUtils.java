package com.loop.test.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

import static org.testng.Assert.*;

public class BrowserUtils {

    /**
     * Validate if driver switched to expected URL and title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * implements assertion
     */

    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle){
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();
        Set <String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles){
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){
                break;
            }
        }
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     * Switch to the new window by the exact title
     * return original window if the window with given title not found
     * @param driver
     * @param targetTitle
     */

    public static void switchTowWindow(WebDriver driver, String targetTitle){
        String origin = driver.getWindowHandle();
        for (String handle :driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(targetTitle)){
                return;
            }
        }
        driver.switchTo().window(origin);

    }





}


