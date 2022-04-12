package ru.diolloyd.locators;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;

public class LoginPageLocators {

    public By loginButton() {
        return MobileBy.AccessibilityId("button-LOGIN");
    }

    public By loginErrorText() {
        return MobileBy.xpath(
                "//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]"
        );
    }

    public By signUpTab() {
        return MobileBy.xpath(
                "//android.view.ViewGroup[@content-desc=\"button-sign-up-container\"]/android.view.ViewGroup/android.widget.TextView\n"
        );
    }

    public By emailField() {
        return MobileBy.xpath(
                "//android.widget.EditText[@content-desc=\"input-email\"]\n"
        );
    }

    public By passwordField() {
        return MobileBy.xpath(
                "//android.widget.EditText[@content-desc=\"input-password\"]\n"
        );
    }

    public By confirmPasswordField() {
        return MobileBy.xpath(
                "//android.widget.EditText[@content-desc=\"input-repeat-password\"]\n"
        );
    }

    public By signUpButton() {
        return MobileBy.xpath(
                "//android.view.ViewGroup[@content-desc=\"button-SIGN UP\"]/android.view.ViewGroup\n"
        );
    }

    public By signUpAlertDialog() {
        return MobileBy.id("android:id/message");
    }

}
