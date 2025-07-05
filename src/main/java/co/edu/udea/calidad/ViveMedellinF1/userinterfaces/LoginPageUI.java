package co.edu.udea.calidad.ViveMedellinF1.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPageUI {

    public static final Target EMAIL_FIELD = Target.the("email input").located(By.xpath("/html/body/div/div[2]/div/form/input[1]"));
    public static final Target PASSWORD_FIELD = Target.the("password input").located(By.xpath("/html/body/div/div[2]/div/form/input[2]"));
    public static final Target CONFIRM_LOGIN_BUTTON = Target.the("login button").located(By.xpath("/html/body/div/div[2]/div/form/button"));
}