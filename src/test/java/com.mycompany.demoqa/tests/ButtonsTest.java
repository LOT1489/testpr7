package com.mycompany.demoqa.tests;

import com.mycompany.demoqa.pages.ButtonsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    @Test
    public void shouldHandleAllClicks() {
        ButtonsPage page = new ButtonsPage(driver, wait);
        page.open();

        page.doubleClick();
        Assert.assertTrue(page.hasDoubleClickMessage(), "Ожидалось сообщение после double click.");

        page.rightClick();
        Assert.assertTrue(page.hasRightClickMessage(), "Ожидалось сообщение после right click.");

        page.dynamicClick();
        Assert.assertTrue(page.hasDynamicClickMessage(), "Ожидалось сообщение после обычного клика.");
    }
}
