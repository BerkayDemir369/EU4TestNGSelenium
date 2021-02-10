package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Question_8 {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterTest
    public void afterTest(){

        driver.quit();
    }

    @Test
    public void test1(){

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/autocomplete']")).click();
        driver.findElement(By.xpath("//input[@id='myCountry']")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        driver.findElement(By.xpath("//p[@id='result']")).isDisplayed();


    }
}
