package ru.diolloyd.locators.android;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import ru.diolloyd.locators.interfaces.BottomNavigationBarLocators;

public class AndroidBottomNavigationBarLocators implements BottomNavigationBarLocators {

    public By loginButton() {
        return MobileBy.AccessibilityId("Login");
    }

    public By formsButton() {
        return MobileBy.AccessibilityId("Forms");
    }

}
