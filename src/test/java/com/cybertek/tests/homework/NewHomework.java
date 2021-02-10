package com.cybertek.tests.homework;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewHomework extends TestBase {
    @Test
    public void test1(){

        //create report
        extentLogger=report.createTest("ContactInfoVerification");
        LoginPage loginPage=new LoginPage();
        //dynamic user name
        loginPage.loginAsStoreManager();
        extentLogger.info("Login as a store Manager");


        new DashboardPage().navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        Assert.assertTrue(calendarEventsPage.options.isDisplayed());






    }

    @Test
    public void test2() throws InterruptedException {
        //create report
        extentLogger=report.createTest("ContactInfoVerification");
        LoginPage loginPage=new LoginPage();
        //dynamic user name
        loginPage.loginAsStoreManager();
        extentLogger.info("Login as a store Manager");

        new DashboardPage().navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();

        wait.until(ExpectedConditions.visibilityOf(calendarEventsPage.pageNumber));

        String actualPageNumber=calendarEventsPage.pageNumber.getAttribute("value");



        Assert.assertEquals(actualPageNumber,"1");




    }
    @Test
    public void test3() throws InterruptedException {
        extentLogger=report.createTest("ContactInfoVerification");
        LoginPage loginPage=new LoginPage();
        //dynamic user name
        loginPage.loginAsStoreManager();
        extentLogger.info("Login as a store Manager");

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();


        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        wait.until(ExpectedConditions.visibilityOf(calendarEventsPage.pageNumber));
        Thread.sleep(3000);
        Assert.assertEquals(calendarEventsPage.perPageNumber.getText(),"25");

    }

    @Test
    public void test4(){

        extentLogger=report.createTest("ContactInfoVerification");
        LoginPage loginPage=new LoginPage();
        //dynamic user name
        loginPage.loginAsStoreManager();
        extentLogger.info("Login as a store Manager");

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();






    }

    @Test
    public void test5(){

        extentLogger=report.createTest("ContactInfoVerification");
        LoginPage loginPage=new LoginPage();
        //dynamic user name
        loginPage.loginAsStoreManager();
        extentLogger.info("Login as a store Manager");

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.selectAllCheckBoxes.click();










    }
}
