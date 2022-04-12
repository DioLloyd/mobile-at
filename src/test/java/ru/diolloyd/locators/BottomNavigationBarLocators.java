package ru.diolloyd.locators;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;

public class BottomNavigationBarLocators {

    public By loginButton() {
        return MobileBy.AccessibilityId("Login");
    }

    public By formsButton() {
        return MobileBy.AccessibilityId("Forms");
    }

}
