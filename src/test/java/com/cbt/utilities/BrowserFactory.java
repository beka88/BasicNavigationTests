package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String operSystem) {
        if (operSystem.equalsIgnoreCase("safari")) {
            return null;
        } else if (operSystem.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (operSystem.equalsIgnoreCase("firefox")) {
            WebDriverManager.chromedriver().setup();
            return new FirefoxDriver();
        } else if (operSystem.equalsIgnoreCase("edge")) {
            WebDriverManager.chromedriver().setup();
            return new EdgeDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    }


}
