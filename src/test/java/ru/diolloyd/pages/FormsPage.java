package ru.diolloyd.pages;

import java.io.File;

import com.codeborne.selenide.Condition;

import io.qameta.allure.Step;
import ru.diolloyd.locators.FormsPageLocators;

import static com.codeborne.selenide.Selenide.$;
import static ru.diolloyd.utils.ScreenshotComparison.compare;

public class FormsPage {

    @Step("Делаем скриншот страницы 'Forms' и сравниваем с требованием")
    public FormsPage checkScreenshot(String expectedScreenshotFilename) {
        File actualScreenshot = $(locator().formsScreen()).screenshot();
        compare(expectedScreenshotFilename, actualScreenshot);
        return this;
    }

    @Step("Кликаем по кнопке 'Active' в форме")
    public FormsPage clickActiveButton() {
        $(locator().activeButton()).click();
        return this;
    }

    @Step("Проверяем текст окна 'This button is'")
    public FormsPage checkDialogText(String text) {
        $(locator().thisButtonIsDialog()).shouldHave(Condition.text(text));
        return this;
    }


    private FormsPageLocators locator() {
        return new FormsPageLocators();
    }

}
