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
import org.testng.annotations.Test;

public class TestScripFrom6to9 {

    private WebDriver driver;
    private String URL = "https://www.tempmailaddress.com/";
    private String URL1 = "https://practice-cybertekschool.herokuapp.com/";

    @Test(description = "Test case 6")
    public void test6(){
        driver.get(URL);
        driver.manage().window().maximize();

        String email = driver.findElement(By.id("email")).getText();
        driver.get(URL1);
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("Ertai Baktai");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).click();

        WebElement message = driver.findElement(By.name("signup_message"));
        String actual = message.getText();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(actual,expected);

        driver.navigate().to("https://www.tempmailaddress.com/");

        BrowserUtils.wait(3);

        WebElement email1 = driver.findElement(By.xpath("//td[@class='from']"));
        String actual1 = email1.getText();
        String expected1 = " do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actual1,expected1);

        BrowserUtils.wait(4);

        driver.findElement(By.xpath("//td[@class='from']")).click();

        WebElement email2 = driver.findElement(By.id("odesilatel"));
        String actual2 = email2.getText();
        String expected2 = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actual2,expected2);

        BrowserUtils.wait(4);

        WebElement email3 = driver.findElement(By.id("predmet"));
        String actual3 = email3.getText();
        String expected3 = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actual3,expected3);

        BrowserUtils.wait(4);
    }

    @Test(description = "Test case 7")
    public void test7(){
        driver.get(URL1);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("File Upload")).click();
        WebElement upload = driver.findElement(By.id("file-upload"));

        String filepath = "C:\\Users\\kenwe\\Desktop\\Newtext.text.txt";
        upload.sendKeys(filepath);

        BrowserUtils.wait(5);

        driver.findElement(By.id("file-submit")).click();

        BrowserUtils.wait(5);

        WebElement upload1 = driver.findElement(By.xpath("//h3"));
        String actual = upload1.getText();
        String expected = "File Uploaded!";

        Assert.assertTrue(upload1.isDisplayed());
        Assert.assertEquals(expected,actual);

        BrowserUtils.wait(5);
    }

    @Test
    public void test8(){
        driver.get(URL1);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        WebElement result = driver.findElement(By.id("result"));
        String actual = result.getText();
        String expected = "You selected: United States of America";
        Assert.assertEquals(actual,expected);
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
