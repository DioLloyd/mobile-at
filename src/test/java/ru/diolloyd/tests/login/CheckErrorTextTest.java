package ru.diolloyd.tests.login;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import ru.diolloyd.base.BaseTest;
import ru.diolloyd.listener.AllureListener;

@Listeners(AllureListener.class)
public class CheckErrorTextTest extends BaseTest {

    private final String VALID_EMAIL_ADDRESS = "Please enter a valid email address";

    @Test
    @Description("Проверяем сообщение об ошибке при невалидной email")
    public void checkEmptyEmail() {
        openApp()
                .clickLoginMenuButton()
                .clickLoginButton()
                .checkLoginErrorText(VALID_EMAIL_ADDRESS);
    }

}
