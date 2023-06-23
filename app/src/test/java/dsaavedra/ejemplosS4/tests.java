package dsaavedra.ejemplosS4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class tests {


    @Test
    void levantarBrowser() throws InterruptedException{
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://selenium.dev");

        Thread.sleep(5000);

        //driver.close();

    }

    @Test
    void levantarBrowserFirefox() throws InterruptedException{
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://selenium.dev");

        Thread.sleep(5000);

        //driver.close();

    }
}
