package ru.diolloyd.tests.swipe;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import ru.diolloyd.base.BaseTest;

public class OpenPageSwipeTest extends BaseTest {

    private final String text = "";

    @Test
    @Description("Открываем страницу 'Swipe'")
    public void swipeCardTest() {
        openApp()
                .clickSwipeMenuButton()
                .swipeFirstCard();
    }


}
