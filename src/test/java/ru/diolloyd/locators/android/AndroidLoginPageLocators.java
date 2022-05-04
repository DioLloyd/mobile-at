package ru.diolloyd.locators.android;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import ru.diolloyd.locators.interfaces.LoginPageLocators;

public class AndroidLoginPageLocators implements LoginPageLocators {

    @Override
    public By loginButton() {
        return MobileBy.AccessibilityId("button-LOGIN");
    }

    @Override
    public By loginErrorText() {
        return MobileBy.xpath(
                "//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]"
        );
    }

    @Override
    public By signUpTab() {
        return MobileBy.xpath(
                "//android.view.ViewGroup[@content-desc=\"button-sign-up-container\"]/android.view.ViewGroup/android.widget.TextView\n"
        );
    }

    @Override
    public By emailField() {
        return MobileBy.xpath(
                "//android.widget.EditText[@content-desc=\"input-email\"]\n"
        );
    }

    @Override
    public By passwordField() {
        return MobileBy.xpath(
                "//android.widget.EditText[@content-desc=\"input-password\"]\n"
        );
    }

    @Override
    public By confirmPasswordField() {
        return MobileBy.xpath(
                "//android.widget.EditText[@content-desc=\"input-repeat-password\"]\n"
        );
    }

    @Override
    public By signUpButton() {
        return MobileBy.xpath(
                "//android.view.ViewGroup[@content-desc=\"button-SIGN UP\"]/android.view.ViewGroup\n"
        );
    }

    @Override
    public By signUpAlertDialog() {
        return MobileBy.id("android:id/message");
    }

}
