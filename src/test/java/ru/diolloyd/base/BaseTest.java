package ru.diolloyd.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import ru.diolloyd.pages.MainPage;

public class BaseTest {

    private static final String url = "http://127.0.0.1:4723/wd/hub";
    private static MobileDriver driver;

    public MainPage openApp() {
        try {
            WebDriver driver = getAndroidDriver();
            WebDriverRunner.setWebDriver(driver);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Некорректный URL драйвера.");
        }
        return new MainPage();
    }

    public static WebDriver getAndroidDriver() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "Pixel");
        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "11");
        capabilities.setCapability("appium:noReset", true);
        capabilities.setCapability("appium:automationName", "UIAutomator2");
        capabilities.setCapability("appium:app", System.getenv("Android-NativeDemoApp"));

        Configuration.reportsFolder = "screenshots/actual";

        driver = new AndroidDriver(new URL(url), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

}
