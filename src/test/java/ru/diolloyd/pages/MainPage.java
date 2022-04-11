package ru.diolloyd.pages;

import java.awt.image.BufferedImage;
import java.io.File;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;

import io.qameta.allure.Step;
import ru.diolloyd.locators.MainPageLocators;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

public class MainPage {

    private MainPageLocators locator() {
        return new MainPageLocators();
    }

    @Step("Кликаем по кнопке логина в меню и переходим на новую страницу логина")
    public LoginPage clickLoginMenuButton() {
        $(locator().loginButton()).click();
        return new LoginPage();
    }

    @Step("Делаем скриншот главной страницы и сравниваем с требованием")
    public MainPage checkScreenshot(String fileName) {
        // Загружаем ожидаемое изображения для сравнения
        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources("src/test/resources/expectedScreenshots/" + fileName);
        // Делаем актуальный скриншот, используя элемент и игнорируя другие части экрана
        File actualScreenshot = $(locator().homeScreen()).screenshot();
        // Загружаем актуальный скриншот
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources("screenshots/actual/" + actualScreenshot.getName());

        // Где будем хранить скриншот с различиями в случае падения теста
        File resultDestination = new File("diff/diff_CheckScreenshot" + fileName);

        // Сравниваем
        ImageComparisonResult imageComparisonResult = new ImageComparison(expectedImage, actualImage, resultDestination).compareImages();
        assertEquals(ImageComparisonState.MATCH, imageComparisonResult.getImageComparisonState());
        return this;
    }

}
