package dsaavedra.page;

import dsaavedra.util.BasePage;
import dsaavedra.util.FixEncoding;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    //Centralizar localizadores
    By locatorCorreo = By.id("email");
    By locatorPassword = By.name("password");
    By locatorUsername = By.xpath("//input[@placeholder='Pon un nombre de perfil.']");
    By locatorDia = By.id("day");
    By locatorMes = By.id("month");
    By locatorAnnio = By.id("year");
    By locatorGenenos = By.xpath("//label[contains(@for,'gender_option_')]");
    By locatorPreferencias = By.xpath("//label[contains(@for,'checkbox')]");
    By btnRegistrate = By.xpath("//button[@type='submit']");

    By locatorErrorCorreoVacio = By.xpath(FixEncoding.fix("//span[contains(text(),'Es necesario que indiques tu correo electrónico.')]"));

    By locatorCerrarCookies = By.xpath("//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']");

    //definir acciones de pagina;
    public void completarFormularioRegistro(String correo,String contrasena,String username,
                                            String dia,String mes,String annio,int genero){

        if(estaDesplegado(locatorCerrarCookies)){
            clickear(esperarPorElemento(locatorCerrarCookies));
        }
        esperarXSegundos(500);
        agregarTexto(esperarPorElemento(locatorCorreo),correo);
        esperarXSegundos(500);
        agregarTexto(esperarPorElemento(locatorPassword),contrasena);
        esperarXSegundos(500);

        agregarTexto(esperarPorElemento(locatorUsername),username);
        esperarXSegundos(500);

        agregarTexto(esperarPorElemento(locatorDia),dia);
        esperarXSegundos(500);

        seleccionarComboBoxPortextoVisible(locatorMes,mes);
        esperarXSegundos(500);

        agregarTexto(esperarPorElemento(locatorAnnio),annio);
        esperarXSegundos(500);

        clickear(buscarElementosWeb(locatorGenenos).get(genero));
        esperarXSegundos(500);

        clickear(buscarElementosWeb(locatorPreferencias).get(0));
        esperarXSegundos(500);

        clickear(buscarElementosWeb(locatorPreferencias).get(1));
        esperarXSegundos(500);

        clickear(esperarPorElemento(btnRegistrate));
        scrollingDownElement(esperarPorElemento(locatorCorreo));
        esperarXSegundos(1500);

    }

    public String obtenerErrorMailVacio(){
        return obtenerTexto(esperarPorElemento(locatorErrorCorreoVacio));
    }
}
