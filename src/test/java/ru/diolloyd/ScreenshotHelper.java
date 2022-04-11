package ru.diolloyd;

import java.io.File;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import ru.diolloyd.base.BaseTest;

import static com.codeborne.selenide.Selenide.$;

public class ScreenshotHelper extends BaseTest {

    @Test
    public void createScreen() {
        openApp();
        File actualScreenshot = $(MobileBy.AccessibilityId("Home-screen")).screenshot();
        System.out.println(actualScreenshot.getName());
    }

}
