package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBoxVerificationTask {
    WebDriver driver;
    @BeforeTest
    public void beforTest() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        checkbox1.click();
        Thread.sleep(2000);
        WebElement verify = driver.findElement(By.xpath("//div[@id='txtAge']"));
        Assert.assertTrue(verify.isDisplayed());
    }
    @Test
    public void test2() {
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement checkAll = driver.findElement(By.xpath("//input[@type='button']"));
        String verifyCheckAll = checkAll.getAttribute("value");
        Assert.assertTrue(verifyCheckAll.equals("Check All"));
        checkAll.click();
        // Find total chekbox count by.classname
        int checkBoxCount = driver.findElements(By.className("cb1-element")).size();
        for (int i = 1; i <= checkBoxCount; i++) {
            //                                                   <input  type="checkbox"  class="cb1-element"  >
            WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'][@class='cb1-element'])[" + i + "]"));
            Assert.assertTrue(checkbox.isSelected(), "verify checkbox " + i + " is selected");
        }
        WebElement unCheck = driver.findElement(By.xpath("//input[@type='button']"));
        String verifyUncheckAll = unCheck.getAttribute("value");
        Assert.assertTrue(verifyUncheckAll.equals("Uncheck All"));
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}