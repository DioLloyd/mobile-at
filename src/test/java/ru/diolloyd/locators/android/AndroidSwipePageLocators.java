package ru.diolloyd.locators.android;

import org.openqa.selenium.By;

import ru.diolloyd.locators.interfaces.SwipePageLocators;

public class AndroidSwipePageLocators implements SwipePageLocators {

    @Override
    public By header() {
        return By.xpath(
                "//android.view.ViewGroup[@content-desc=\"Swipe-screen\"]/android.view.ViewGroup[1]/android.widget.TextView"
        );
    }

    @Override
    public By firstCardText() {
        return By.xpath(
                "(//android.view.ViewGroup[@content-desc=\"card\"])[1]/android.widget.TextView[2]"
        );
    }

    @Override
    public By centerCardText() {
        return By.xpath(
                "(//android.view.ViewGroup[@content-desc=\"card\"])[2]/android.widget.TextView[2]"
        );
    }
}
