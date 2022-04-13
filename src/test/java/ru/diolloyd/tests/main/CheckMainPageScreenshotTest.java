package ru.diolloyd.tests.main;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import ru.diolloyd.base.BaseTest;
import ru.diolloyd.listener.AllureListener;

@Listeners(AllureListener.class)
public class CheckMainPageScreenshotTest extends BaseTest {

    private final String SCREENSHOT_NAME = "mainPage.png";

    @Test
    @Description("Проверяем UI главной страницы с помощью скриншота")
    public void checkMainPageScreenshot() {
        openApp()
                .checkScreenshot(SCREENSHOT_NAME);
    }

}
