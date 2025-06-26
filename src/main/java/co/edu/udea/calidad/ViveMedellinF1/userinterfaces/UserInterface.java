package co.edu.udea.calidad.ViveMedellinF1.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class UserInterface extends PageObject {
    public static final Target LOGIN_BUTTON = Target.the("iniciar sesion button").located(By.xpath("/html/body/div/div[2]/div/form/button"));
    public static final Target EMAIL_FIELD = Target.the("email field").located(By.xpath("/html/body/div/div[2]/div/form/input[1]"));
    public static final Target PASSWORD_FIELD = Target.the("password field").located(By.xpath("/html/body/div/div[2]/div/form/input[2]"));
    public static final Target LOGIN_FORM = Target.the("login form").located(By.xpath("/html/body/div/div[2]/div/form"));
    public static final Target RETURN_BUTTON = Target.the("regresar button").located(By.xpath("/html/body/div/div[1]/div/a/div/h1"));
    public static final Target USER_BUTTON = Target.the("user button").located(By.xpath("/html/body/div/div[1]/nav/div[3]/svg"));
    public static final Target LOGIN_TITTLE = Target.the("undefined tittle").located(By.xpath("/html/body/div/div[1]/nav/div[3]/div/div/span"));
}
