package ru.diolloyd.tests.forms;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import ru.diolloyd.base.BaseTest;
import ru.diolloyd.listener.AllureListener;

@Listeners(AllureListener.class)
public class CheckFormsPageScreenshotTest extends BaseTest {

    private final String SCREENSHOT_NAME = "formsPage.png";

    @Test
    @Description("Проверяем UI страницы 'Forms' с помощью скриншота")
    public void checkFormsPageScreenshot() {
        openApp()
                .clickFormsMenuButton()
                .checkScreenshot(SCREENSHOT_NAME);
    }

}
