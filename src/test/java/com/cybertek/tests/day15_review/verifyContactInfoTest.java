package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {


    /* open the chrome
       go to https://qa1.vytrack.com/user/login
       login as a sales manager
       navigate to customers ->contacts
       click on email mbrackstone9@example.com
       verfy that full name is Mariam Brackstone
       verify that email is mbrackstone9@example.com
       verify that phone number is +18982323434
       */


     @Test
    public void contactDetailsTest(){


         //create report
         extentLogger=report.createTest("ContactInfoVerification");


         LoginPage loginPage=new LoginPage();


         String username= ConfigurationReader.get("salesmanager_username");
         String password=ConfigurationReader.get("salesmanager_password");

         //dynamic user name
         extentLogger.info("username: " + username);
         extentLogger.info("pasword: " + password);
         extentLogger.info("Login as a Sale Manager");


         loginPage.login(username,password);
         extentLogger.info("Navigate to Customer > Contacts");



         //navigate to customer contact
         //we can not call BasePage because it is abstract class

//         DashboardPage dashboardPage= new DashboardPage();
//         dashboardPage.navigateToModule();
         //if you use only one time not need to save you can do instead of this


         //lazy way if you wanna use only one time so this is the shortcut
         new DashboardPage().navigateToModule("Customers","Contacts");

         //locator by xpath //td[text()='mbrackstone9@example.com']

         //locator by contains //td[contains(text(),'mbrackstone9@example.com')]
         // make more unique locator //td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']


         ContactsPage contactsPage=new ContactsPage();

         extentLogger.info("Click on mbrackstone9@example.com");
         contactsPage.waitUntilLoaderScreenDisappear();
         contactsPage.getContactEmail("mbrackstone9@example.com").click();



         ContactInfoPage contactInfoPage=new ContactInfoPage();

         String expectedFullName="Mariam Brackstone";
         String actualFullName=contactInfoPage.fullName.getText();

         extentLogger.info("Verify full name is " + expectedFullName);
         Assert.assertEquals(actualFullName,expectedFullName,"verify fullname");

         extentLogger.info("Verify the email mbrackstone9@example.com");
         Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com","verify email");

         extentLogger.info("Verify phone number is +18982323434");
         Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","verify Phone number");



         //after everything is pass
         extentLogger.pass("PASSED");







     }











}
