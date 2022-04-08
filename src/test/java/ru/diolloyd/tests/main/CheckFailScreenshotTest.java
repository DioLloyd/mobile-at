package ru.diolloyd.tests.main;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import ru.diolloyd.base.BaseTest;
import ru.diolloyd.listener.AllureListener;

@Listeners(AllureListener.class)
public class CheckFailScreenshotTest extends BaseTest {

    private final String SCREENSHOT_NAME = "badMainPage.png";

    @Test
    @Description("Проверяем поведение теста при неудачной проверке UI главной страницы с помощью скриншота")
    public void checkFailMainPageScreenshot() {
        openApp()
                .checkScreenshot(SCREENSHOT_NAME);
    }

}
