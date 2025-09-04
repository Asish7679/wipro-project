package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String fileName) {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotDir = "target/screenshots/";
            File dest = new File(screenshotDir + fileName + "_" + timestamp + ".png");

            dest.getParentFile().mkdirs();

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), dest.toPath());

            System.out.println("📸 Screenshot saved: " + dest.getAbsolutePath());
            return dest.getAbsolutePath();
        } catch (Exception e) {
            System.out.println("❌ Failed to take screenshot: " + e.getMessage());
            return null;
        }
    }
}
