package ru.diolloyd.pages;

import com.codeborne.selenide.Condition;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import ru.diolloyd.locators.LoginPageLocators;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private LoginPageLocators locator() {
        return new LoginPageLocators();
    }

    @Step("Кликаем по кнопке 'Login' в форме")
    public LoginPage clickLoginButton() {
        $(locator().loginButton()).click();
        return new LoginPage();
    }
    
    @Step("Проверяем текст ошибки")
    public LoginPage checkLoginErrorText(String text) {
        $(locator().loginErrorText()).shouldHave(Condition.text(text));
        return new LoginPage();
    }

    @Step("Нажимаем вкладку 'SignUp'")
    public LoginPage clickSignUpTab() {
        $(locator().signUpTab()).click();
        return new LoginPage();
    }

    @Step("Заполняем поле 'Email'")
    public LoginPage inputEmail(String email) {
        $(locator().emailField()).setValue(email);
        return new LoginPage();
    }

    @Step("Заполняем поле 'Password'")
    public LoginPage inputPassword(String password) {
        $(locator().passwordField()).setValue(password);
        return new LoginPage();
    }

    @Step("Заполняем поле 'Confirm password'")
    public LoginPage inputConfirmPassword(String confirmPassword) {
        $(locator().confirmPasswordField()).setValue(confirmPassword);
        return new LoginPage();
    }

    @Step("Нажимаем кнопку 'SignUp'")
    public LoginPage clickSignUpButton() {
        $(locator().signUpButton()).click();
        return new LoginPage();
    }

    @SneakyThrows
    @Step("Проверяем текст успешной авторизации")
    public LoginPage checkSuccessfulSignUpText(String text) {
        $(locator().signUpAlertDialog()).shouldHave(Condition.text(text));
        return new LoginPage();
    }



}
