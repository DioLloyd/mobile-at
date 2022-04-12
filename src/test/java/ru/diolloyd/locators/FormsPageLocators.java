package ru.diolloyd.locators;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;

public class FormsPageLocators {

    public By formsScreen() {
        return MobileBy.AccessibilityId("Forms-screen");
    }

    public By activeButton() {
        return MobileBy.AccessibilityId("button-Active");
    }

    public By thisButtonIsDialog() {
        return MobileBy.id("android:id/message");
    }

}
