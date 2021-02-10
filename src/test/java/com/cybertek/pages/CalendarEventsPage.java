package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[@class='btn btn-link dropdown-toggle']")
    public WebElement options;

    @FindBy(xpath = "//input[@value='1']")
    public WebElement pageNumber;

    @FindBy(css = "button.btn.dropdown-toggle")
    public WebElement perPageNumber;

    @FindBy(css = "label.dib:nth-child(4)")
    public WebElement recordNumber;

    @FindBy(xpath = "//div[@class='btn-group dropdown']" )
    public WebElement selectAllCheckBoxes;


    @FindBy(className = "grid-row")
    public WebElement recordPerPage;

}