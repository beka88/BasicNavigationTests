package com.cbt.tests.homework3;

import com.cbt.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;


public class TestScriptFrom9To12 {

    private WebDriver driver;
    private String URL1 = "https://practice-cybertekschool.herokuapp.com/";

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL1);
        driver.findElement(By.linkText("Status Codes")).click();
    }

    @DataProvider(name = "TestData")
        public static Object[] TestData () {
            return new Object[]{"200", "301", "404", "500"};
        }

        @Test(dataProvider = "TestData")
        public void testFrom9To12 (String code){
            WebElement codes = driver.findElement(By.linkText(code));
            codes.click();
            WebElement codes1 = driver.findElement(By.xpath("//p"));
            String actual = codes1.getText();
            String expected = "This page returned a "+code+" status code.";

            Assert.assertTrue(actual.contains(expected));
        }


        @AfterMethod
        public void tearDown () {
            driver.quit();
        }

    }

