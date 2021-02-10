package com.cybertek.tests.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class task2 {

//    @Test
//    public void test1(){
//        WebDriver driver=WebDriverFactory.getDriver("chrome");
//        driver.get("https://www.ebay.com");
//        WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
//        search.sendKeys("shoes");
//        //click search button
//        driver.findElement(By.xpath("//input[@type='submit']")).click();
//
//        WebElement result=driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
//
//        String resultText=result.getText();
//        System.out.println("resultText = " + resultText);
//
//    }
//
    @Test
    public void test2(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com");
        WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
        search.sendKeys("Selenium");
        //click search button
        driver.findElement(By.xpath("//input[@type='submit']")).click();






    }


}
