package co.edu.udea.calidad.ViveMedellinF1.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomePageUI extends PageObject {
    public static final Target REGISTER_BUTTON = Target.the("Go to Registrarse").located(By.xpath("/html/body/div/div[1]/nav/div[3]/div/a[2]/div/h1"));
}
