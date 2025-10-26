package com.mycompany.demoqa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends BasePage {
    private final By alertBtn = By.id("alertButton");
    private final By confirmBtn = By.id("confirmButton");
    private final By promptBtn = By.id("promtButton");
    private final By confirmResult = By.id("confirmResult");
    private final By promptResult = By.id("promptResult");

    public AlertsPage(WebDriver d, WebDriverWait w) { super(d, w); }

    public void open() { open("https://demoqa.com/alerts"); }

    public void acceptSimpleAlert() {
        click(alertBtn);
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void dismissConfirm() {
        click(confirmBtn);
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    public void sendToPrompt(String text) {
        click(promptBtn);
        Alert a = wait.until(ExpectedConditions.alertIsPresent());
        a.sendKeys(text);
        a.accept();
    }

    public String getConfirmResult() { return el(confirmResult).getText(); }
    public String getPromptResult() { return el(promptResult).getText(); }
}
