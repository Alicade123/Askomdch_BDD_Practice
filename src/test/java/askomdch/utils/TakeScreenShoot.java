package askomdch.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TakeScreenShoot {

    public static void takeScreenshot(WebDriver driver, String testName) {
        try {
            TakesScreenshot capture = (TakesScreenshot) driver;
            File source = capture.getScreenshotAs(OutputType.FILE);
            DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
            String time = LocalDateTime.now().format(formatter);

            Path destinationDir = Path.of("src/test/resources/failedScreenshot");
            Files.createDirectories(destinationDir);
            Path destination =destinationDir.resolve(testName + "_" + time + ".png");
            Files.move(source.toPath(), destination);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
