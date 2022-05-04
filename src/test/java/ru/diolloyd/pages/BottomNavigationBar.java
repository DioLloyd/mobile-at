package ru.diolloyd.pages;

import io.qameta.allure.Step;
import ru.diolloyd.locators.LocatorService;
import ru.diolloyd.locators.interfaces.BottomNavigationBarLocators;

import static com.codeborne.selenide.Selenide.$;

public class BottomNavigationBar {

    @Step("Кликаем по кнопке Login в меню навигации и переходим на страницу 'Login / Sign up From'")
    public LoginPage clickLoginMenuButton() {
        $(locator().loginButton()).click();
        return new LoginPage();
    }

    @Step("Кликаем по кнопке Forms в меню навигации и переходим на страницу 'Form components'")
    public FormsPage clickFormsMenuButton() {
        $(locator().formsButton()).click();
        return new FormsPage();
    }


    private BottomNavigationBarLocators locator() {
        return LocatorService.BOTTOM_NAVIGATION_BAR_LOCATORS;
    }

}
