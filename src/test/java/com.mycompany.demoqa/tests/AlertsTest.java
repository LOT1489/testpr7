package com.mycompany.demoqa.tests;

import com.mycompany.demoqa.pages.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    @Test
    public void shouldAcceptSimpleAlert() {
        AlertsPage page = new AlertsPage(driver, wait);
        page.open();
        page.acceptSimpleAlert();
        Assert.assertTrue(true, "Simple alert accepted (проверка нет падения).");
    }

    @Test
    public void shouldDismissConfirm() {
        AlertsPage page = new AlertsPage(driver, wait);
        page.open();
        page.dismissConfirm();
        Assert.assertTrue(page.getConfirmResult().toLowerCase().contains("cancel") ||
                        page.getConfirmResult().toLowerCase().contains("dismiss"),
                "Ожидалось, что результат подтверждения покажет отклонение. Результат: " + page.getConfirmResult());
    }

    @Test
    public void shouldSendTextToPrompt() {
        AlertsPage page = new AlertsPage(driver, wait);
        page.open();
        String text = "HelloDemoQA";
        page.sendToPrompt(text);
        Assert.assertTrue(page.getPromptResult().contains(text),
                "Ожидалось, что введённый текст покажется в результате prompt. Получено: " + page.getPromptResult());
    }
}
