package co.edu.udea.calidad.ViveMedellinF1.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class NavigationBarUI extends PageObject {

    // Target dinámico que se adapta al texto del enlace que queremos.
    // El '%s' será reemplazado por el nombre de la sección: "Eventos y Actividades", "Comunidades", etc.
    public static final Target NAVIGATION_LINK = Target.the("Enlace de navegacion a '{0}'").locatedBy("//a[contains(text(),'{0}')]");

}
