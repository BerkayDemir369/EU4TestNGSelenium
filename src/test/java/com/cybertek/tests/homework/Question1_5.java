package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Question1_5 {


    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        driver= WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();


    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test

    public void test1() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement registration= driver.findElement(By.xpath("//a[@href='/registration_form']"));
        Thread.sleep(2000);

        //scrollDownAndUp

        JavascriptExecutor jse=(JavascriptExecutor) driver;

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");

        }
        registration.click();

         //sendkeys to box;
        WebElement dateOfBirth=driver.findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirth.sendKeys("wrong_dob");

        // verify the displayed message
        String actual= driver.findElement(By.xpath("//small[@style='display: block;']")).getText();
        String expected="The date of birth is not valid";
        Assert.assertEquals(actual,expected);



    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");


        WebElement registration= driver.findElement(By.xpath("//a[@href='/registration_form']"));
        Thread.sleep(2000);

        //scrollDownAndUp

        JavascriptExecutor jse=(JavascriptExecutor) driver;

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");

        }
        registration.click();

        WebElement element1= driver.findElement(By.xpath("//label[@for='inlineCheckbox1']"));
        element1.isDisplayed();
        WebElement element2=driver.findElement(By.xpath("//label[@for='inlineCheckbox2']"));
        element2.isDisplayed();
        WebElement element3=driver.findElement(By.xpath("//label[@for='inlineCheckbox3']"));
        element2.isDisplayed();



    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");


        WebElement registration= driver.findElement(By.xpath("//a[@href='/registration_form']"));
        Thread.sleep(2000);

        //scrollDownAndUp

        JavascriptExecutor jse=(JavascriptExecutor) driver;

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");

        }
        registration.click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("B");
        WebElement firstName=driver.findElement(By.xpath("(//small[@data-bv-for='firstname'])[2]"));
        firstName.isDisplayed();

    }
     @Test
    public void test4() throws InterruptedException {


         driver.get("https://practice-cybertekschool.herokuapp.com");


         WebElement registration= driver.findElement(By.xpath("//a[@href='/registration_form']"));
         Thread.sleep(2000);

         //scrollDownAndUp

         JavascriptExecutor jse=(JavascriptExecutor) driver;

         for (int i = 0; i < 10; i++) {
             Thread.sleep(1000);
             jse.executeScript("window.scrollBy(0,250)");

         }
         registration.click();

         driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("D");
         WebElement lastname=driver.findElement(By.xpath("(//small[@data-bv-for='firstname'])[3]"));
         lastname.isDisplayed();


     }

     @Test
    public void test5() throws InterruptedException {

         driver.get("https://practice-cybertekschool.herokuapp.com");


         WebElement registration= driver.findElement(By.xpath("//a[@href='/registration_form']"));
         Thread.sleep(2000);

         //scrollDownAndUp

         JavascriptExecutor jse=(JavascriptExecutor) driver;

         for (int i = 0; i < 10; i++) {
             Thread.sleep(1000);
             jse.executeScript("window.scrollBy(0,250)");

         }
         registration.click();

         driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Berkay");
         driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Demir");
         driver.findElement(By.xpath("//input[@name='username']")).sendKeys("AutomationTestEngineer");
         driver.findElement(By.xpath("//input[@name='email']")).sendKeys("brky.dmr@gmail.com");
         driver.findElement(By.xpath("//input[@name='password']")).sendKeys("B.demir123456");
         driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("571-000-0000");
         driver.findElement(By.xpath("//input[@value='male']")).click();
         driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("03/24/1991");






         //select dropdown list

         WebElement departmentElement=driver.findElement(By.xpath("//select[@name='department']"));
         Select department= new Select(departmentElement);
         Thread.sleep(1000);
         department.selectByVisibleText("Department of Engineering");

         //SELECT dropdown list


         WebElement jopTitle=driver.findElement(By.xpath("//select[@name='job_title']"));

         Select jop= new Select(jopTitle);
         Thread.sleep(1000);
         jop.selectByVisibleText("SDET");

         driver.findElement(By.xpath("//input[@id='inlineCheckbox2']")).click();
         driver.findElement(By.id("wooden_spoon")).click();



         //
         //create Explicit wait object

         WebElement completeMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']/p"));
         WebDriverWait wait = new WebDriverWait(driver,10);

         wait.until(ExpectedConditions.visibilityOf(completeMessage));
         completeMessage.isDisplayed();







     }
}
