package dsaavedra.ejemplosS4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TareaLocators {
    //Atributos
    private WebDriver driver;

    private JavascriptExecutor js; //manipular eventos como el scroll

    //Métodos
    @BeforeEach
    void preparacion(){
        //prepararemos el driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); //instanciamos el driver

        //prerara el js executor
        js = (JavascriptExecutor) driver;

        driver.get("https://open.spotify.com/"); //levantar sitio Spotify
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
    void CP001_RegistroOK(){
        //Forma #1 de interactuar con un elemento web (Xpath)
        driver.findElement(By.xpath("//button[contains(text(),'Registrarte')]")).click();

        //Forma #2
        By locatorTxtEmail = By.id("email"); // (ID)
        WebElement txtEmail = driver.findElement(locatorTxtEmail);

        txtEmail.clear();
        txtEmail.sendKeys("mailprueba123423324234423fsdfd154@algo.com");

        //Forma #3 (NAME)
        driver.findElement(By.name("password")).sendKeys("asdasdfasdf234234");

        driver.findElement(By.xpath("//input[@placeholder='Pon un nombre de perfil.']")).sendKeys("Pobre Domingo");

        driver.findElement(By.id("day")).sendKeys("28");

        driver.findElement(By.id("year")).sendKeys("1991");

        //Manejo de ComboBox/drop down list
        By locatorDDLMes =  By.id("month");
        WebElement ddlMes = driver.findElement(locatorDDLMes);
        Select  selectorMes = new Select(ddlMes);

        //selectorMes.selectByValue("10");
        selectorMes.selectByVisibleText("Febrero");

        List<WebElement> listaGeneros = driver.findElements(By.xpath("//label[contains(@for,'gender_option_')]"));

        listaGeneros.get(3).click();


        List<WebElement> listaChecks = driver.findElements(By.xpath("//label[contains(@for,'checkbox')]"));


        if(listaChecks.get(0).isDisplayed()){
            listaChecks.get(0).click();
        }

        if(listaChecks.get(1).isEnabled()){
            listaChecks.get(1).click();
        }

        WebElement btnRegistrarse = driver.findElement(By.xpath("//button[@type='submit']"));

        js.executeScript("arguments[0].scrollIntoView(true);", btnRegistrarse);

        btnRegistrarse.click();

        Assertions.assertEquals("Descubrir Premium",driver.findElement(By.xpath("//span[contains(text(),'Descubrir Premium')]")).getText());
    }

    @Test
    void CP002_RegistroNOOK_Username_Vacio(){
        //Forma #1 de interactuar con un elemento web (Xpath)
        driver.findElement(By.xpath("//button[contains(text(),'Registrarte')]")).click();

        //Forma #2
        By locatorTxtEmail = By.id("email"); // (ID)
        WebElement txtEmail = driver.findElement(locatorTxtEmail);

        txtEmail.clear();
        txtEmail.sendKeys("mailprueba123554325344@algo.com");

        //Forma #3 (NAME)
        driver.findElement(By.name("password")).sendKeys("asdasdfasdf234234");

        driver.findElement(By.xpath("//input[@placeholder='Pon un nombre de perfil.']")).sendKeys("Pobre Domingo");

        driver.findElement(By.id("day")).sendKeys("28");

        driver.findElement(By.id("year")).sendKeys("1991");

        //Manejo de ComboBox/drop down list
        By locatorDDLMes =  By.id("month");
        WebElement ddlMes = driver.findElement(locatorDDLMes);
        Select  selectorMes = new Select(ddlMes);

        //selectorMes.selectByValue("10");
        selectorMes.selectByVisibleText("Febrero");

        List<WebElement> listaGeneros = driver.findElements(By.xpath("//label[contains(@for,'gender_option_')]"));

        listaGeneros.get(3).click();


        List<WebElement> listaChecks = driver.findElements(By.xpath("//label[contains(@for,'checkbox')]"));


        if(listaChecks.get(0).isDisplayed()){
            listaChecks.get(0).click();
        }

        if(listaChecks.get(1).isEnabled()){
            listaChecks.get(1).click();
        }

        WebElement btnRegistrarse = driver.findElement(By.xpath("//button[@type='submit']"));

        js.executeScript("arguments[0].scrollIntoView(true);", btnRegistrarse);

        btnRegistrarse.click();

        Assertions.assertEquals("Indica un nombre para tu perfil.",driver.findElement(By.xpath("//span[contains(text(),'Indica un nombre para tu perfil.')]")).getText());
    }



    @AfterEach
    void posEjecucion(){
        //cerrar el browser
        driver.close();
    }
}
