package ru.diolloyd.tests.login;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import ru.diolloyd.base.BaseTest;
import ru.diolloyd.listener.AllureListener;

@Listeners(AllureListener.class)
public class SuccessfulRegistrationTest extends BaseTest {

    private final String EMAIL = "email@email.com";
    private final String PASSWORD = "password";
    private final String EXPECTED_SUCCESSFUL_TEXT = "You successfully signed up!";

    @Test
    @Description("Проверка успешной регистрации")
    public void successfulRegistration() {
        openApp()
                .clickLoginMenuButton()
                .clickSignUpTab()
                .inputEmail(EMAIL)
                .inputPassword(PASSWORD)
                .inputConfirmPassword(PASSWORD)
                .clickSignUpButton()
                .checkSuccessfulSignUpText(EXPECTED_SUCCESSFUL_TEXT);
    }

}
