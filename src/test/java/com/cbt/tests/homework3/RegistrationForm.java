package com.cbt.tests.homework3;

import com.cbt.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {

    private WebDriver driver;
    private String URL = "https://practice-cybertekschool.herokuapp.com/";

    @Test(description = "Verify that warning message is displayed",priority = 0)
    public void test1(){
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        WebElement warningmessage = driver.findElement(By.xpath("//small[text()='The date of birth is not valid']"));

        String actual = warningmessage.getText();
        String expected = "The date of birth is not valid";

        Assert.assertEquals(actual,expected);

        BrowserUtils.wait(5);
    }

    @Test(description = "Verify following are displayed c++, java, JavaScript",priority = 1)
    public void test2(){

        WebElement cPlusPlus =driver.findElement(By.xpath("//label[text()='C++']"));
        String actual = cPlusPlus.getText();
        String expected = "C++";
        Assert.assertEquals(actual,expected);

        WebElement java =driver.findElement(By.xpath("//label[text()='Java']"));
        String actual1 = java.getText();
        String expected1 = "Java";
        Assert.assertEquals(actual1,expected1);

        WebElement javaScript =driver.findElement(By.xpath("//label[text()='JavaScript']"));
        String actual2 =javaScript.getText();
        String expected2 = "JavaScript";
        Assert.assertEquals(actual2,expected2);
    }
    @Test(description = "Warning message displayed",priority = 2)
        public void test3(){
        driver.findElement(By.name("firstname")).sendKeys("b");
        BrowserUtils.wait(4);
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        String actual = warningMessage.getText();
        String expected = "first name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actual,expected);
    }

    @Test(description = "Warning message",priority = 3)
    public void test4(){
        driver.findElement(By.name("lastname")).sendKeys("c");
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));
        String actual = warningMessage.getText();
        String expected = "The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actual,expected);
    }

    @Test(description = "You've successfully completed registration",priority = 4)
    public void test5(){
        driver.findElement(By.name("firstname")).sendKeys("Ertai");
        driver.findElement(By.name("lastname")).sendKeys("Baktai");
        driver.findElement(By.name("username")).sendKeys("Ertaichuk");
        driver.findElement(By.name("password")).sendKeys("AyturErtai");
        driver.findElement(By.name("phone")).sendKeys("980-777-7878");
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.name("email")).sendKeys("beka@gamil.com");
        driver.findElement(By.name("birthday")).sendKeys("10/10/1980");

        Select departmantSelect = new Select(driver.findElement(By.name("department")));
        departmantSelect.selectByVisibleText("Accounting Office");

        Select jobTitleSelect = new Select(driver.findElement(By.name("job_title")));
        jobTitleSelect.selectByVisibleText("QA");

        driver.findElement(By.id("inlineCheckbox2")).click();

        BrowserUtils.wait(5000);

        driver.findElement(By.id("wooden_spoon")).click();

        WebElement message = driver.findElement(By.cssSelector("h4+p"));
        String actual = message.getText();
        String expected = "You've successfully completed registration!";
        Assert.assertEquals(actual,expected);
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Registration Form")).click();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
