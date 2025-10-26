package com.mycompany.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage extends BasePage {
    private final By userName = By.id("userName");
    private final By userEmail = By.id("userEmail");
    private final By currentAddress = By.id("currentAddress");
    private final By permanentAddress = By.id("permanentAddress");
    private final By submit = By.id("submit");
    private final By output = By.id("output");
    private final By emailField = By.id("userEmail");

    public TextBoxPage(WebDriver d, WebDriverWait w) { super(d, w); }

    public void open() { open("https://demoqa.com/text-box"); }

    public void fill(String name, String email, String curr, String perm) {
        el(userName).clear(); el(userName).sendKeys(name);
        el(userEmail).clear(); el(userEmail).sendKeys(email);
        el(currentAddress).clear(); el(currentAddress).sendKeys(curr);
        el(permanentAddress).clear(); el(permanentAddress).sendKeys(perm);
        click(submit);
    }

    public boolean isOutputVisible() { return el(output).isDisplayed(); }

    public String getOutputText() { return el(output).getText(); }

    public String emailCssClass() { return driver.findElement(emailField).getAttribute("class"); }
}
