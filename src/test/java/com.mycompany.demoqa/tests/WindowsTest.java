package com.mycompany.demoqa.tests;

import com.mycompany.demoqa.pages.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsTest extends BaseTest {

    @Test
    public void shouldOpenNewTabAndVerifyContent() {
        WindowsPage page = new WindowsPage(driver, wait);
        page.open();
        String heading = page.openNewTabAndGetHeadingText();
        Assert.assertNotNull(heading, "Ожидалось содержание в новой вкладке (sampleHeading).");
        Assert.assertTrue(heading.toLowerCase().contains("sample"), "Ожидалось, что heading содержит слово sample. Получено: " + heading);
    }
}
