package ru.diolloyd;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;

public class AndroidNativeDemoAppTests {

    private final String url = "http://127.0.0.1:4723/wd/hub";
    private final DesiredCapabilities capabilities = new DesiredCapabilities();
    private MobileDriver driver;

    @SneakyThrows
    @BeforeMethod
    public void setupDriver() {
        capabilities.setCapability("appium:deviceName", "Pixel");
        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "11");
        capabilities.setCapability("appium:noReset", true);
        capabilities.setCapability("appium:automationName", "UIAutomator2");
        capabilities.setCapability("appium:app", System.getenv("Android-NativeDemoApp"));

        driver = new AndroidDriver(new URL(url), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void close() {
        driver.quit();
    }

    @Test
    public void checkEmptyEmail() {
        String expectedErrorText = "Please enter a valid email address";
        MobileElement loginMenuButton = (MobileElement) driver.findElementByAccessibilityId("Login");
        loginMenuButton.click();

        MobileElement loginButton = (MobileElement) driver.findElementByAccessibilityId("button-LOGIN");
        loginButton.click();

        MobileElement emailError = (MobileElement) driver.findElementByXPath(
                "//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]\n"
        );

        Assert.assertEquals(emailError.getText(), expectedErrorText);
    }

    @Test
    public void successfulRegistration() {
        String expectedErrorText = "You successfully signed up!";
        MobileElement loginMenuButton = (MobileElement) driver.findElementByAccessibilityId("Login");
        loginMenuButton.click();

        MobileElement signUpTab = (MobileElement) driver.findElementByXPath(
                "//android.view.ViewGroup[@content-desc=\"button-sign-up-container\"]/android.view.ViewGroup/android.widget.TextView\n"
        );
        signUpTab.click();

        MobileElement emailField = (MobileElement) driver.findElementByXPath(
                "//android.widget.EditText[@content-desc=\"input-email\"]\n"
        );
        emailField.sendKeys("email@email.com");

        MobileElement passwordField = (MobileElement) driver.findElementByXPath(
                "//android.widget.EditText[@content-desc=\"input-password\"]\n"
        );
        passwordField.sendKeys("password");

        MobileElement confirmPasswordField = (MobileElement) driver.findElementByXPath(
                "//android.widget.EditText[@content-desc=\"input-repeat-password\"]\n"
        );
        confirmPasswordField.sendKeys("password");

        MobileElement signUpButton = (MobileElement) driver.findElementByXPath(
                "//android.view.ViewGroup[@content-desc=\"button-SIGN UP\"]/android.view.ViewGroup\n"
        );
        signUpButton.click();

        MobileElement successful = (MobileElement) driver.findElementById("android:id/message");
        Assert.assertEquals(successful.getText(), expectedErrorText);
    }

}
