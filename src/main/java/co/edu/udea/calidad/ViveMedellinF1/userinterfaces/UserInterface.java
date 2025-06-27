package co.edu.udea.calidad.ViveMedellinF1.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class UserInterface extends PageObject {
    public static final Target LOGIN_BUTTON = Target.the("iniciar sesion button").located(By.xpath("/html/body/div/div[2]/div/form/button"));
    public static final Target EMAIL_FIELD = Target.the("email field").located(By.xpath("/html/body/div/div[2]/div/form/input[1]"));
    public static final Target PASSWORD_FIELD = Target.the("password field").located(By.xpath("/html/body/div/div[2]/div/form/input[2]"));
    public static final Target RETURN_BUTTON = Target.the("regresar button").located(By.xpath("/html/body/div/div[1]/div/a/div/h1"));
    public static final Target USER_BUTTON = Target.the("user button").located(By.xpath("/html/body/div/div[1]/nav/div[3]/svg"));
    public static final Target LOGIN_TITTLE = Target.the("undefined tittle").located(By.xpath("/html/body/div/div[1]/nav/div[3]/div/div/span"));

    public static final Target EVENTOS_ACTIVIDADES_LINK = Target.the("Eventos y Actividades link").located(By.xpath("/html/body/div/div[2]/nav/div[1]/div"));
    public static final Target COMUNIDADES_LINK = Target.the("Comunidades link").located(By.xpath("/html/body/div/div[2]/nav/div[2]/div"));
    public static final Target VALORACIONES_LINK = Target.the("Valoraciones link").located(By.xpath("/html/body/div/div[2]/nav/div[3]/div"));

    public static final Target EVENTOS_ACTIVIDADES_PAGE_TITLE = Target.the("Eventos y Actividades page title").located(By.xpath("/html/body/div/div[2]/div/div/div[1]/div/h1"));
    public static final Target COMUNIDADES_PAGE_TITLE = Target.the("Comunidades page title").located(By.xpath("/html/body/div/div[2]/div/div"));
    public static final Target VALORACIONES_PAGE_TITLE = Target.the("Valoraciones page title").located(By.xpath("/html/body/div/div[2]/div/div"));

    public static final Target REGISTRO_LINK = Target.the("register link").located(By.xpath("/html/body/div/div[2]/div/div[2]/a/div"));
    public static final Target REGISTRO_FORM = Target.the("register form").located(By.xpath("/html/body/div/div[2]/div/form[1]"));
    public static final Target LOGIN_LINK_ON_REGISTER_PAGE = Target.the("login link on register page").located(By.xpath("/html/body/div/div[2]/div/div[1]/div[1]/div/a/div"));

}
