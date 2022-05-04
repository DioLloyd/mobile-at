package ru.diolloyd.pages;

import com.codeborne.selenide.Condition;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import ru.diolloyd.locators.LocatorService;
import ru.diolloyd.locators.interfaces.LoginPageLocators;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BottomNavigationBar {

    @Step("Кликаем по кнопке 'Login' в форме")
    public LoginPage clickLoginButton() {
        $(locator().loginButton()).click();
        return this;
    }

    @Step("Проверяем текст ошибки")
    public LoginPage checkLoginErrorText(String text) {
        $(locator().loginErrorText()).shouldHave(Condition.text(text));
        return this;
    }

    @Step("Нажимаем вкладку 'SignUp'")
    public LoginPage clickSignUpTab() {
        $(locator().signUpTab()).click();
        return this;
    }

    @Step("Заполняем поле 'Email'")
    public LoginPage inputEmail(String email) {
        $(locator().emailField()).setValue(email);
        return this;
    }

    @Step("Заполняем поле 'Password'")
    public LoginPage inputPassword(String password) {
        $(locator().passwordField()).setValue(password);
        return this;
    }

    @Step("Заполняем поле 'Confirm password'")
    public LoginPage inputConfirmPassword(String confirmPassword) {
        $(locator().confirmPasswordField()).setValue(confirmPassword);
        return this;
    }

    @Step("Нажимаем кнопку 'SignUp'")
    public LoginPage clickSignUpButton() {
        $(locator().signUpButton()).click();
        return this;
    }

    @SneakyThrows
    @Step("Проверяем текст успешной авторизации")
    public LoginPage checkSuccessfulSignUpText(String text) {
        $(locator().signUpAlertDialog()).shouldHave(Condition.text(text));
        return this;
    }


    private LoginPageLocators locator() {
        return LocatorService.LOGIN_PAGE_LOCATORS;
    }

}
