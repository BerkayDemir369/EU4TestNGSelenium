package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Question_9 {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }
    @Test(dataProvider = "StatusCodes")
    public void test9_10_11_12(String code, String message) {
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Status Codes")).click();

        driver.findElement(By.linkText(code)).click();
        //driver.findElement(By.xpath("//a[@href='status_codes/"+code+"']"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/div/p")).getText().contains(message));

    }

    @DataProvider(name="StatusCodes")
    public Object[][] getText(){
        Object[][] codes =
                {{"200","This page returned a 200 status code."},
                {"301","This page returned a 301 status code."},
                {"404","This page returned a 404 status code."},
                {"500","This page returned a 500 status code."}};
        return codes;
    }

}

