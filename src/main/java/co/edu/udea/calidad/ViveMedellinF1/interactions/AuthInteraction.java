package co.edu.udea.calidad.ViveMedellinF1.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.edu.udea.calidad.ViveMedellinF1.userinterfaces.UserInterface.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class AuthInteraction implements Interaction {

    private final String email;
    private final String password;

    public AuthInteraction(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email).into(EMAIL_FIELD),
                Enter.theValue(password).into(PASSWORD_FIELD),
                WaitUntil.the(LOGIN_BUTTON, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(LOGIN_BUTTON),
                WaitUntil.the(LOGIN_BUTTON, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(RETURN_BUTTON)
        );
    }

    public static AuthInteraction withCredentials(String email, String password) {
        return Tasks.instrumented(AuthInteraction.class, email, password);
    }
}