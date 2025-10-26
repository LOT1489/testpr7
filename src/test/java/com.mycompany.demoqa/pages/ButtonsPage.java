package com.mycompany.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonsPage extends BasePage {
    private final By doubleClickBtn = By.id("doubleClickBtn");
    private final By rightClickBtn = By.id("rightClickBtn");
    private final By dynamicBtn = By.xpath("//button[text()='Click Me']");
    private final By dblMsg = By.id("doubleClickMessage");
    private final By rgtMsg = By.id("rightClickMessage");
    private final By dynMsg = By.id("dynamicClickMessage");

    public ButtonsPage(WebDriver d, WebDriverWait w) { super(d, w); }

    public void open() { open("https://demoqa.com/buttons"); }

    public void doubleClick() {
        WebElement btn = el(doubleClickBtn);
        new Actions(driver).doubleClick(btn).perform();
    }

    public void rightClick() {
        WebElement btn = el(rightClickBtn);
        new Actions(driver).contextClick(btn).perform();
    }

    public void dynamicClick() {
        click(dynamicBtn);
    }

    public boolean hasDoubleClickMessage() { return el(dblMsg).isDisplayed(); }
    public boolean hasRightClickMessage() { return el(rgtMsg).isDisplayed(); }
    public boolean hasDynamicClickMessage() { return el(dynMsg).isDisplayed(); }
}
