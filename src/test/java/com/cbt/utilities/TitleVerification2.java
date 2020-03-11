package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com/", "https://walmart.com", "https://westelm.com/");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        for (int i = 0; i <urls.size() ; i++) {
            driver.get(urls.get(i));
        }

        for (int i = 0; i <urls.size() ; i++) {
            String title = driver.getTitle().replace(" ","").toLowerCase();
            if(urls.get(i).equals(title)){
                System.out.println("TEST PASSED");
            }else{
                System.out.println("TEST FAILED");
            }

        }


         driver.quit();
    }
}
