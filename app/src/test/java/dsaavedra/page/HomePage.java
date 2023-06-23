package dsaavedra.page;

import dsaavedra.util.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores
    By locatorRegistrarte = By.xpath("//button[contains(text(),'Registrarte')]");

    //acciones del sitio
    public void irARegistrarse(){
        clickear(esperarPorElemento(locatorRegistrarte));
    }
}
