package co.edu.udea.calidad.ViveMedellinF1.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class RegistrationPageUI extends PageObject {
    public static final Target NAME_FIELD = Target.the("name input").located(By.xpath("/html/body/div/div[2]/div/form/input[1]"));
    public static final Target LASTNAME_FIELD = Target.the("lastname input").located(By.xpath("/html/body/div/div[2]/div/form/input[2]"));
    public static final Target EMAIL_FIELD = Target.the("email input").located(By.xpath("/html/body/div/div[2]/div/form/input[3]"));
    public static final Target PASSWORD_FIELD = Target.the("password input").located(By.xpath("/html/body/div/div[2]/div/form/input[4]"));
    public static final Target CONFIRM_PASSWORD_FIELD = Target.the("confirm password input").located(By.xpath("/html/body/div/div[2]/div/form/input[5]"));
    public static final Target CREATE_ACCOUNT_BUTTON = Target.the("create account button").located(By.xpath("/html/body/div/div[2]/div/form/div/button"));
    public static final Target LOGIN_LINK = Target.the("Go to Login Page").located(net.serenitybdd.core.annotations.findby.By.xpath("/html/body/div/div[2]/div/div/div[1]/div/a/div"));
}
