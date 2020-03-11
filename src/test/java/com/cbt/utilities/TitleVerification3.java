package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com/", "https://walmart.com", "https://westelm.com/");

        for (int i = 0; i <urls.size() ; i++) {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get(urls.get(i));
            String title = driver.getTitle().replace(" ","").toLowerCase();

            if(urls.get(i).contains(title)){
                System.out.println("TEST PASSED "+ urls.get(i)+"title "+title );
            }else{
                System.out.println("TEST FAILED "+urls.get(i)+"title "+ title);
            }
            driver.quit();
        }

    }
}
