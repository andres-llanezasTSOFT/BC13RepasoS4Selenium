package dsaavedra.test;

import dsaavedra.page.HomePage;
import dsaavedra.page.RegisterPage;
import dsaavedra.util.BasePage;
import dsaavedra.util.FixEncoding;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests {
    private HomePage homePage;
    private RegisterPage registerPage;
    private WebDriver driver;

    @BeforeEach
    public void preTests(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(homePage.getDriver());
        homePage.cargarUrl("https://open.spotify.com/?");
        homePage.maximizarBrowser();
    }

    @AfterEach
    public void postTest(){
        driver.close();
    }

    @Test
    public void CP001_formulario_incorrecto_mail_vacio(){
        homePage.irARegistrarse();
        registerPage.completarFormularioRegistro("","awedawseddasdas",
                "Domingo","30","Marzo","1990",0);
        Assertions.assertEquals(FixEncoding.fix("Es necesario que indiques tu correo electrónico."),
                registerPage.obtenerErrorMailVacio());
    }
}
