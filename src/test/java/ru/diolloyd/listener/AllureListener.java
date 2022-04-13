package ru.diolloyd.listener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.codeborne.selenide.Selenide;

import io.qameta.allure.Attachment;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        /**
         * Логика для прикрепления скриншота для функциональных тестов, и где сравниваются скриншоты.
         * Если тест связан со скриншотом, в отчёт allure мы прикрепляем скриншоты с
         * отличиями актуального результата от ожидаемого.
         */
        if (result.getName().contains("Screenshot")) {
            // Получаем путь до скриншота с отличиями.
            String filePath = "diff/diff_" + testName + ".png";
            try {
                // Прикрепляем скриншот к отчёту allure.
                saveScreenshot(Files.readAllBytes(Paths.get(filePath)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Если тест функциональный, то к отчёту прикрепляем скриншот с момента падения теста.
            saveScreenshot(Selenide.screenshot(OutputType.BYTES));
        }
    }

    // Метод прикрепляет скриншот к отчёту allure.
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

}
