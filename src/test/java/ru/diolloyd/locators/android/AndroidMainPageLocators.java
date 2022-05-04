package ru.diolloyd.locators.android;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import ru.diolloyd.locators.interfaces.MainPageLocators;

public class AndroidMainPageLocators implements MainPageLocators {

    public By homeScreen() {
        return MobileBy.AccessibilityId("Home-screen");
    }

}
