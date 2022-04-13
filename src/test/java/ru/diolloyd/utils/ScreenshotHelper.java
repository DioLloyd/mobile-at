package ru.diolloyd.utils;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;

import io.appium.java_client.MobileBy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.diolloyd.base.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

/**
 * Утилита для создания скриншотов страниц.
 * Скриншоты создаются в 'src/test/resources/createdScreenshots/'.
 * В метод create() нужно передать enum необходимой страницы.
 * Расширяется добавлением элементов в enum AddressLocator и
 * соответствующий им case в openPage() для перехода на необходимую страницу.
 */

public class ScreenshotHelper extends BaseTest {

    public static void main(String[] args) {
        create(AddressLocator.formsPage);
    }

    public static void create(AddressLocator addressLocator) {
        openPage(addressLocator);
        createScreenshot(addressLocator);
    }

    private static void openPage(AddressLocator addressLocator) {
        switch (addressLocator) {
            case mainPage:
                openApp();
                break;
            case formsPage:
                openApp().clickFormsMenuButton();
                break;
        }
    }

    private static void createScreenshot(AddressLocator addressLocator) {
        File screenshot = $(MobileBy.AccessibilityId(addressLocator.getAccessibilityId())).screenshot();
        boolean screenRenamed = screenshot.renameTo(new File(addressLocator.getSrc() + ".png"));
        if (!screenRenamed) {
            screenRenamed = screenshot.renameTo(
                    new File(addressLocator.getSrc() + randomString() + ".png")
            );
            assertTrue(screenRenamed);
        }
    }

    private static String randomString() {
        return RandomStringUtils.randomAlphanumeric(5);
    }


    @AllArgsConstructor
    @Getter
    private enum AddressLocator {

        mainPage("src/test/resources/createdScreenshots/Home-screen", "Home-screen"),
        formsPage("src/test/resources/createdScreenshots/Forms-screen", "Forms-screen");

        private final String src;
        private final String accessibilityId;

    }

}
