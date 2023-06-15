package allanezas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TareaLocators {

    private WebDriver driver;
    JavascriptExecutor js;

    @BeforeEach
    void preparacion(){
        //prepara el driver
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        //prepara el js executor
        js=(JavascriptExecutor) driver;
        driver.get("https://www.spotify.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    void CP0001_RegistroNOOK_Username(){

    }
}
