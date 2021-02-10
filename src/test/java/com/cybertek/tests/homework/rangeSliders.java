package com.cybertek.tests.homework;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class rangeSliders {

    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    public void closePopup() throws InterruptedException {
        Thread.sleep(2000);
        if (driver.findElement(By.id("at-cv-lightbox")).isDisplayed()) {
            driver.findElement(By.xpath("//a[@class='at-cv-button at-cv-lightbox-yesno at-cm-no-button']")).click();
            //driver.findElement(By.xpath("//*[.='No, thanks!']")).click();
        }
    }


    @Test
    public void rangeTest1() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test");
        closePopup();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.xpath("//a[contains(text(),'Progress Bars & Sliders')]")).click();
        driver.findElement(By.xpath("//div[@class='container-fluid text-center']//*[text()='Drag & Drop Sliders']")).click();
        js.executeScript("window.scrollBy(0,500)");

        WebElement[][] range = new WebElement[3][2];
        for (int i = 0; i < range.length; i++) {
            for (int j = 0; j < 2; j++) {

                //find default values
                range[i][j] = driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/section[1]/div[" + (i + 1) + "]/div[" + (j + 1) + "]/div[1]/input[1]"));

                //System.out.println("range[" + i + "][" + j + "].getAttribute(\"value\")= " + range[i][j].getAttribute("value"));

                // update values

                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("arguments[0].value='80';", range[i][j]); // change value
                jse.executeScript("arguments[0].onchange();", range[i][j]); // trigger onchange

                // System.out.println("range[" + i + "][" + j + "].getAttribute(\"value\")= " + range[i][j].getAttribute("value"));
            }
        }

        Thread.sleep(2000);

    }
}
