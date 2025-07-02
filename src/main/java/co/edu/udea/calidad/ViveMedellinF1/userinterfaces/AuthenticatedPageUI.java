package co.edu.udea.calidad.ViveMedellinF1.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AuthenticatedPageUI extends PageObject {

    public static final Target USERNAME_GREETING = Target.the("User name").located(By.xpath("/html/body/div/div[1]/nav/div[3]/div/div/span"));
}