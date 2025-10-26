package com.mycompany.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerPage extends BasePage {
    private final By dateInput = By.id("datePickerMonthYearInput");
    private final By dateTimeInput = By.id("dateAndTimePickerInput");

    public DatePickerPage(WebDriver d, WebDriverWait w) { super(d, w); }

    public void open() { open("https://demoqa.com/date-picker"); }

    public void setDate(String date) {
        // формат: "MM/dd/yyyy" или любой, который поле принимает; проще — очистить и ввести
        var elDate = el(dateInput);
        elDate.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        elDate.sendKeys(date);
        elDate.sendKeys(Keys.ENTER);
    }

    public String getDateValue() { return driver.findElement(dateInput).getAttribute("value"); }
}
