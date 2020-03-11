package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");
        List<String> titles = new ArrayList<>();

        WebDriver driver = BrowserFactory.getDriver("chrome");

        for (int i = 0; i <urls.size()-1 ; i++) {
            driver.get(urls.get(i));
            titles.add(driver.getTitle());
            if(titles.get(i).equals(titles.get(i+1))){
                System.out.println(titles.get(i)+ "they are same");
        }
        }
        }

    }

