package dsaavedra;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class SeleniumBrowserActions {

    private String titulo;
    private WebDriver driver;

    @BeforeEach
    void preparacionTests(){
        //preparar el webdriver
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(); //instanciar un objeto WebDriver (browser)


        //administrar los tiempos de respuesta de carga de pagina
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterEach
    void posEjecucion(){
        //driver.close();
    }

    @Test
    void browserActions(){
        //cargar una pagina
        driver.get("https://www.google.cl");

        titulo = driver.getTitle();
        System.out.println("El titulo del sitio es: "+titulo);

        //maximizar browser
        driver.manage().window().maximize();

        //redireccionar a otra pagina
        driver.navigate().to("https://www.selenium.dev");

        titulo = driver.getTitle();
        System.out.println("El titulo del sitio es: "+titulo);

        //refresh
        driver.navigate().refresh();

        //volver a google
        driver.navigate().back();

        titulo = driver.getTitle();
        System.out.println("El titulo del sitio es: "+titulo);
    }


    @Test
    void validarPaginaIniciarSesionSpotify(){
        driver.get("https://open.spotify.com/");

        By locatorBtnIniciarSesion = By.xpath("//button[@data-testid='login-button']");

        WebElement btnIniciarSesion = driver.findElement(locatorBtnIniciarSesion);

        btnIniciarSesion.click();

        Assertions.assertEquals(fixEncoding("Inicia sesión en Spotify"),driver.findElement(By.xpath("//h1[contains(text(),'Inicia sesi')]")).getText());
    }

    public static String fixEncoding(String text){
        byte[]  utf8Bytes = text.getBytes(StandardCharsets.ISO_8859_1);
        return new String(utf8Bytes,StandardCharsets.UTF_8);
    }


}
