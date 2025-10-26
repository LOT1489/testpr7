package com.mycompany.demoqa.tests;

import com.mycompany.demoqa.pages.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    @Test
    public void shouldSubmitValidData() {
        TextBoxPage page = new TextBoxPage(driver, wait);
        page.open();
        page.fill("Ivan Petrov", "ivan.petrov@example.com", "Moscow", "Saint Petersburg");
        Assert.assertTrue(page.isOutputVisible(), "Ожидалось появление блока вывода после отправки формы.");
        Assert.assertTrue(page.getOutputText().contains("Ivan Petrov"), "Ожидалось имя в выводе.");
    }

    @DataProvider(name = "invalidEmails")
    public Object[][] invalidEmails() {
        return new Object[][] {
                {"plainaddress"},
                {"missing@domain"},
                {"@missinglocal.com"}
        };
    }

    @Test(dataProvider = "invalidEmails")
    public void shouldHighlightInvalidEmail(String email) {
        TextBoxPage page = new TextBoxPage(driver, wait);
        page.open();
        page.fill("Ivan Petrov", email, "Moscow", "SPb");
        String css = page.emailCssClass();
        // DemoQA подсвечивает классами — проверяем наличие "error" или схожих индикаторов
        Assert.assertTrue(css != null && (css.contains("field-error") || css.contains("error") || css.contains("invalid")),
                "Ожидалась визуальная индикация ошибки у поля email для: " + email + ". Атрибут class: " + css);
    }
}
