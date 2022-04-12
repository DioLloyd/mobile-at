package ru.diolloyd.tests.forms;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import ru.diolloyd.base.BaseTest;
import ru.diolloyd.enums.Device;
import ru.diolloyd.listener.AllureListener;

@Listeners(AllureListener.class)
public class CheckButtonIsActiveTest extends BaseTest {

    private final String text = "This button is active";

    @Test
    @Parameters({"Pixel_1", "Pixel_2"})
    @Description("Проверяем UI страницы 'Forms' с помощью скриншота")
    public void checkButtonIsActive() {
        openApp(Device.PIXEL_1.name)
                .clickFormsMenuButton()
                .clickActiveButton()
                .checkDialogText(text);
    }

}
