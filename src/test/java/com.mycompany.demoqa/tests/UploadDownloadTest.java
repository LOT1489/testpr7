package com.mycompany.demoqa.tests;

import com.mycompany.demoqa.pages.UploadDownloadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadDownloadTest extends BaseTest {

    @Test
    public void shouldUploadFileAndShowPath() {
        UploadDownloadPage page = new UploadDownloadPage(driver, wait);
        page.open();
        Path p = Paths.get(System.getProperty("user.home"), "Desktop", "demoqa_test_file.txt");
        String abs = p.toAbsolutePath().toString();
        page.uploadFile(abs);
        String res = page.uploadedPath();
        Assert.assertTrue(res.contains("demoqa_test_file.txt"), "Ожидалось отображение имени загруженного файла. Получено: " + res);
    }
}
