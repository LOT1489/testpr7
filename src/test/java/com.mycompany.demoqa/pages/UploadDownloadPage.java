package com.mycompany.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadDownloadPage extends BasePage {
    private final By upload = By.id("uploadFile");
    private final By uploaded = By.id("uploadedFilePath");

    public UploadDownloadPage(WebDriver d, WebDriverWait w) { super(d, w); }

    public void open() { open("https://demoqa.com/upload-download"); }

    public void uploadFile(String absolutePath) {
        driver.findElement(upload).sendKeys(absolutePath);
    }

    public String uploadedPath() { return el(uploaded).getText(); }
}
