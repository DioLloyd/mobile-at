package ru.diolloyd.locators.android;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import ru.diolloyd.locators.interfaces.BottomNavigationBarLocators;

public class AndroidBottomNavigationBarLocators implements BottomNavigationBarLocators {

    @Override
    public By loginButton() {
        return MobileBy.AccessibilityId("Login");
    }

    @Override
    public By formsButton() {
        return MobileBy.AccessibilityId("Forms");
    }

    @Override
    public By swipeButton() {
        return MobileBy.AccessibilityId("Swipe");
    }

}
