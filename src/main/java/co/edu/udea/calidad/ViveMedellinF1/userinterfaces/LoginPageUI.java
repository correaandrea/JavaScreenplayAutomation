package co.edu.udea.calidad.ViveMedellinF1.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPageUI extends PageObject {
    public static final Target INPUT_LOGIN_EMAIL = Target.the("email input login").located(By.xpath("/html/body/div/div[2]/div/form/input[1]"));
    public static final Target INPUT_LOGIN_PASSWORD = Target.the("password input login").located(By.xpath("/html/body/div/div[2]/div/form/input[2]"));
    public static final Target BUTTON_LOGIN = Target.the("iniciar sesion button").located(By.xpath("/html/body/div/div[2]/div/form/button"));
}