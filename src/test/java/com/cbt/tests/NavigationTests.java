package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTests {

    public static void Chrome(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        String title = driver.getTitle();
        driver.get("https://etsy.com");
        String title1 = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(title,driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(title1,driver.getTitle());

        driver.close();
    }

    public static void FireFox(){
        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("https://google.com");
        String title = driver.getTitle();
        driver.get("https://etsy.com");
        String title1 = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(title,driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(title,driver.getTitle());

        driver.close();
    }

    public static void Edge(){
        WebDriver driver = BrowserFactory.getDriver("edge");
        driver.get("https://google.com");
        String title = driver.getTitle();
        driver.get("https://etsy.com");
        String title1 = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(title,driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(title,driver.getTitle());

        driver.close();
    }

    public static void main(String[] args) {
        Chrome();
        FireFox();
        Edge();

    }
    }

