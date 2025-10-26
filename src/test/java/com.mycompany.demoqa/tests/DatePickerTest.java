package com.mycompany.demoqa.tests;

import com.mycompany.demoqa.pages.DatePickerPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatePickerTest extends BaseTest {

    @Test
    public void shouldSetAndReadDate() {
        DatePickerPage page = new DatePickerPage(driver, wait);
        page.open();
        String date = "10/21/2025";
        page.setDate(date);
        String value = page.getDateValue();
        Assert.assertTrue(value.contains("2025") || value.contains("10/21"), "Ожидалось, что дата установлена. Получено: " + value);
    }
}
