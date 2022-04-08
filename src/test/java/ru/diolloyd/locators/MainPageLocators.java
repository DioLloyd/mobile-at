package ru.diolloyd.locators;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;

public class MainPageLocators {

    public By loginButton() {
        return MobileBy.AccessibilityId("Login");
    }

    public By homeScreen() {
        return MobileBy.AccessibilityId("Home-screen");
    }

}
