package co.edu.udea.calidad.ViveMedellinF1.interactions;

import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.RegistrationPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

public class FillRegistrationForm implements Interaction {

    private final String name;
    private final String lastname;
    private final String email;
    private final String password;
    private final String confirmPassword;

    public FillRegistrationForm(String name, String lastname, String email, String password, String confirmPassword) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(name).into(RegistrationPageUI.NAME_FIELD),
                Enter.theValue(lastname).into(RegistrationPageUI.LASTNAME_FIELD),
                Enter.theValue(email).into(RegistrationPageUI.EMAIL_FIELD),
                Enter.theValue(password).into(RegistrationPageUI.PASSWORD_FIELD),
                Enter.theValue(confirmPassword).into(RegistrationPageUI.CONFIRM_PASSWORD_FIELD)
        );
    }

    public static FillRegistrationForm withDetails(String... details) {
        return Tasks.instrumented(FillRegistrationForm.class, details[0], details[1], details[2], details[3], details[4]);
    }
}