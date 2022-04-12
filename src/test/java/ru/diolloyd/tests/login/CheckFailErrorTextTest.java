package ru.diolloyd.tests.login;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import ru.diolloyd.base.BaseTest;
import ru.diolloyd.enums.Device;
import ru.diolloyd.listener.AllureListener;

/**
 * Специально падающий тест для проверки, что в Allure отчёте
 * всё будет описано верно и появится скриншот.
 */

@Listeners(AllureListener.class)
public class CheckFailErrorTextTest extends BaseTest {

    private final String VALID_EMAIL_ADDRESS = "Please enter a valid email address";

    @Test
    @Description("Проверяем поведения теста при падении проверки сообщения об ошибке валидного email")
    public void checkFailEmptyEmail() {
        openApp(Device.PIXEL_2.name)
                .clickLoginMenuButton()
                .checkLoginErrorText(VALID_EMAIL_ADDRESS);
    }

}
