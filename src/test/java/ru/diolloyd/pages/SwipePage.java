package ru.diolloyd.pages;

import io.qameta.allure.Step;
import ru.diolloyd.locators.LocatorService;
import ru.diolloyd.locators.interfaces.SwipePageLocators;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static org.testng.Assert.assertEquals;

public class SwipePage {

    @Step("Проверяем текст header'а на странице Swipe")
    public SwipePage checkHeader(String expectedHeaderText) {
        String actualHeaderText = $(locator().header()).getText();
        assertEquals(expectedHeaderText, actualHeaderText);
        return this;
    }

    @Step("Проверяем текст первой карточки на странице")
    public SwipePage checkFirstCardText(String expectedHeaderText) {
        String actualHeaderText = $(locator().firstCardText()).getText();
        assertEquals(expectedHeaderText, actualHeaderText);
        return this;
    }

    @Step("Проверяем текст первой карточки на странице")
    public SwipePage swipeFirstCard() {
        actions()
//                .click($(locator().centerCardText()))
                .click($(locator().firstCardText()))
//                .moveToElement($(locator().firstCardText()));
                .moveToElement($(locator().centerCardText()));
        return this;
    }

    @Step("Проверяем центральной карточки на странице")
    public SwipePage checkCenterCardText(String expectedHeaderText) {
        String actualHeaderText = $(locator().centerCardText()).getText();
        assertEquals(expectedHeaderText, actualHeaderText);
        return this;
    }


    private SwipePageLocators locator() {
        return LocatorService.SWIPE_PAGE_LOCATORS;
    }

}
