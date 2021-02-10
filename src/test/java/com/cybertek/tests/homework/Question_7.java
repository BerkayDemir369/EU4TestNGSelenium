package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Question_7 {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterTest
    public void closeBrowser(){

       // driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/upload']")).click();
        Thread.sleep(16000);

        //locating choose file button
        WebElement chooseFile = driver.findElement(By.name("file"));
        //sending file with sendKeys method
        chooseFile.sendKeys("C://Users//PC//Desktop//textfile.txt");
        //clicking upload button
        driver.findElement(By.id("file-submit")).click();

        //verify subject is "file uploaded"
        driver.findElement(By.xpath("//h3")).isDisplayed();

        String actualFileName= driver.findElement(By.id("uploaded-files")).getText();
        //verify file name is file.txt
        Assert.assertEquals(actualFileName,"textfile.txt");



    }


}
