package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SharedDriver {
    private static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            configureWebDriver();
        }
        return webDriver;
    }

    private static void configureWebDriver() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }

    public static void closeDriver() {
        if (webDriver != null) {
            webDriver.close();
        }

    }

}
