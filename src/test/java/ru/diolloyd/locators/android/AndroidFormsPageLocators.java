package ru.diolloyd.locators.android;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import ru.diolloyd.locators.interfaces.FormsPageLocators;

public class AndroidFormsPageLocators implements FormsPageLocators {

    @Override
    public By formsScreen() {
        return MobileBy.AccessibilityId("Forms-screen");
    }

    @Override
    public By activeButton() {
        return MobileBy.AccessibilityId("button-Active");
    }

    @Override
    public By thisButtonIsDialog() {
        return MobileBy.id("android:id/message");
    }

}
