package ru.diolloyd.tests.forms;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import ru.diolloyd.base.BaseTest;
import ru.diolloyd.listener.AllureListener;

@Listeners(AllureListener.class)
public class CheckButtonIsActiveTest extends BaseTest {

    private final String text = "This button is active";

    @Test
    @Description("Проверяем UI страницы 'Forms' с помощью скриншота")
    public void checkButtonIsActive() {
        openApp()
                .clickFormsMenuButton()
                .clickActiveButton()
                .checkDialogText(text);
    }

}
