package com.mycompany.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class WindowsPage extends BasePage {
    private final By newTabBtn = By.id("tabButton");
    private final By newWindowBtn = By.id("windowButton");
    private final By sampleHeading = By.id("sampleHeading");

    public WindowsPage(WebDriver d, WebDriverWait w) { super(d, w); }

    public void open() { open("https://demoqa.com/browser-windows"); }

    public String openNewTabAndGetHeadingText() {
        String original = driver.getWindowHandle();
        click(newTabBtn);
        wait.until(driver -> driver.getWindowHandles().size() > 1);
        Set<String> handles = driver.getWindowHandles();
        for (String h : handles) {
            if (!h.equals(original)) {
                driver.switchTo().window(h);
                try {
                    return el(sampleHeading).getText();
                } finally {
                    driver.close();
                    driver.switchTo().window(original);
                }
            }
        }
        return null;
    }
}
