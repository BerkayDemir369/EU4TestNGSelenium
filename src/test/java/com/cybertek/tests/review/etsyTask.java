package com.cybertek.tests.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class etsyTask {
    public static void main(String[] args) {


        changingLocator("Art & Collectibles");

   }

     public static WebDriver changingLocator(String locator){

         WebDriver driver= WebDriverFactory.getDriver("chrome");
         driver.get("https://www.etsy.com");
         WebElement accept=driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--filled wt-mb-xs-0']"));
         accept.click();

         WebElement search = driver.findElement(By.xpath("//span[contains(.,'" + locator + "')]"));
         search.click();

        return driver;

     }

     @Test
    public void testEtsy(){
         WebDriver driver= WebDriverFactory.getDriver("chrome");
         driver.get("https://www.etsy.com");
         WebElement accept=driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--filled wt-mb-xs-0']"));
         accept.click();
         String locator="Art & Collectibles";
         WebElement search = driver.findElement(By.xpath("//span[contains(.,'" + locator + "')]"));
         search.click();

     }
}
