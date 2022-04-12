package ru.diolloyd.pages;

import java.io.File;

import io.qameta.allure.Step;
import ru.diolloyd.locators.MainPageLocators;

import static com.codeborne.selenide.Selenide.$;
import static ru.diolloyd.utils.ScreenshotComparison.compare;

public class MainPage extends BottomNavigationBar {

    @Step("Делаем скриншот главной страницы и сравниваем с требованием")
    public MainPage checkScreenshot(String expectedScreenshotFilename) {
        // Делаем актуальный скриншот, используя элемент и игнорируя другие части экрана
        File actualScreenshot = $(locator().homeScreen()).screenshot();
        compare(expectedScreenshotFilename, actualScreenshot);
        return this;
    }


    private MainPageLocators locator() {
        return new MainPageLocators();
    }

}
