package co.edu.udea.calidad.ViveMedellinF1.interactions;

import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.LoginPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

public class FillLoginForm implements Interaction {

    private final String email;
    private final String password;

    public FillLoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email).into(LoginPageUI.EMAIL_FIELD),
                Enter.theValue(password).into(LoginPageUI.PASSWORD_FIELD)
        );
    }

    public static FillLoginForm withCredentials(String email, String password) {
        return Tasks.instrumented(FillLoginForm.class, email, password);
    }
}

