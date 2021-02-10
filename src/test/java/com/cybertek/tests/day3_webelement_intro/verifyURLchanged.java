package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {
    public static void main(String[] args) {

        /* Verify URL changed

         -open chrome browser
         -go to http://practice.cybertekschool.com/forgot_password  Links to an external site
         -click on Retrieve password
         -enter any email
         -click on Retrieve password
         -verify that url changed to http://practice.cybertekschool.com/email_sent

        */

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("cHrome");

        // go to  http://practice.cybertek.school.com/forgot_password

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        //sendKeys()--> send keyboard action to the webElement
        emailInputBox.sendKeys("mike@cybertek.com");

        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //TASK
        //-verify that url changed to http://practice.cybertekschool.com/email_sent
        //Create expectedURL
        String expectadUrl="http://practice.cybertekschool.com/email_sent";

        String actualUrl= driver.getCurrentUrl();

        if(expectadUrl.equals(actualUrl)){
            System.out.println("PASS");

        }else{
            System.out.println("FAIL");
            System.out.println("expectedUrl = " + expectadUrl);
            System.out.println("actualUrl = " + actualUrl);
        }

        //CLOSE BROWSER
        driver.close();























    }
}
