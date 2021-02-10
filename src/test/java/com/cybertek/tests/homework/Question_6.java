package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Question_6 {


    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


    }
    @AfterTest
    public void closeBrowser(){

        driver.quit();
    }

    @Test

    public void test1() throws InterruptedException {

        driver.get("https://www.tempmailaddress.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //click and copy valid fake email
        driver.findElement(By.xpath("(//a[@title='Copy this email address'])[2]")).click();



        //open second page
        driver.get("https://practice-cybertekschool.herokuapp.com");


        WebElement dropdownLink = driver.findElement(By.xpath("//a[@href='/sign_up']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();", dropdownLink);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Berkay");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.chord(Keys.CONTROL, "v"));


        driver.findElement(By.xpath("//button[@name='wooden_spoon']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//h3[@name='signup_message']")).isDisplayed();

        //navigate to back
        driver.navigate().to("https://www.tempmailaddress.com");


        //verify the email is from
        String reply=" do-not-reply@practice.cybertekschool.com";

        System.out.println("pass");
        String emailFrom= driver.findElement(By.xpath("(//td[@class='from'])[1]")).getText();
        Assert.assertEquals(emailFrom,reply);

        //verify the subject

        String subject="Thanks for subscribing to practice.cybertekschool.com!";

        String emailText=driver.findElement(By.xpath("(//td)[2]")).getText();


        Assert.assertEquals(emailText,subject);






    }
}
