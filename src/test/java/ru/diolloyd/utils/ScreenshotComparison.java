package ru.diolloyd.utils;

import java.awt.image.BufferedImage;
import java.io.File;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;

import static org.testng.Assert.assertEquals;

public class ScreenshotComparison {

    public static void compare(String expectedScreenshotFilename, File actualScreenshot) {
        // Загружаем ожидаемое изображения для сравнения
        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources("src/test/resources/expectedScreenshots/" + expectedScreenshotFilename);
        // Загружаем актуальный скриншот
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources("screenshots/actual/" + actualScreenshot.getName());

        // Где будем хранить скриншот с различиями в случае падения теста
        File resultDestination = new File("diff/diff_CheckScreenshot" + expectedScreenshotFilename);

        // Сравниваем
        ImageComparisonResult imageComparisonResult = new ImageComparison(expectedImage, actualImage, resultDestination).compareImages();
        assertEquals(ImageComparisonState.MATCH, imageComparisonResult.getImageComparisonState());
    }

}
