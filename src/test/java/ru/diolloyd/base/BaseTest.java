package ru.diolloyd.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import ru.diolloyd.pages.MainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    private static final String url = "http://127.0.0.1:4723/wd/hub";

    public static MainPage openApp() {
        try {
            WebDriver driver = getAppiumDriver();
            WebDriverRunner.setWebDriver(driver);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Некорректный URL драйвера.");
        }
        return new MainPage();
    }

    public static WebDriver getAppiumDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (System.getProperty("platform")) {
            case "Android":
                capabilities.setCapability("appium:deviceName", "Pixel");
                capabilities.setCapability("appium:udid", "emulator-5554");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("appium:platformVersion", "11");
                capabilities.setCapability("appium:noReset", true);
                capabilities.setCapability("appium:automationName", "UIAutomator2");
                capabilities.setCapability("appium:app", System.getenv("Android-NativeDemoApp"));
                break;
            case "iOS": {
                // Примерные настройки для iOS. Должны быть такого вида.
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("deviceName", "iPhone");
                capabilities.setCapability("platformVersion", "15");
                capabilities.setCapability("udid", "2E20F3A4-ACC1-4799-A4F5-83358E56AB2E");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("app", "ПУТЬ_ДО_ПРИЛОЖЕНИЯ");
                break;
            }
        }

        Configuration.reportsFolder = "screenshots/actual";

        MobileDriver driver = new AppiumDriver(new URL(url), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @AfterClass
    public void close() {
        closeWebDriver();
    }

}
