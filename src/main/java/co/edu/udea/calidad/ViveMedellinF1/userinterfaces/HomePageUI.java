package co.edu.udea.calidad.ViveMedellinF1.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomePageUI extends PageObject {
    public static final Target REGISTER_BUTTON = Target.the("Go to Register").located(By.xpath("/html/body/div/div[1]/nav/div[3]/div/a[2]/div/h1"));
    public static final Target LOGIN_BUTTON = Target.the("Go to Login").located(By.xpath("/html/body/div/div[1]/nav/div[3]/div/a[1]/div/h1"));
    public static final Target SECTION_EVENTOS = Target.the("Eventos section").located(By.xpath("/html/body/div/div[2]/nav/div[1]/div/h1"));
    public static final Target SECTION_COMUNIDADES = Target.the("comunidades section").located(By.xpath("/html/body/div/div[2]/nav/div[2]/div/h1"));
    public static final Target SECTION_VALORACIONES = Target.the("Valoraciones section").located(By.xpath("/html/body/div/div[2]/nav/div[3]/div/h1"));

}
