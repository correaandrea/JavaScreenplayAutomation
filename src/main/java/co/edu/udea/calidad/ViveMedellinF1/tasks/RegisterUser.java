package co.edu.udea.calidad.ViveMedellinF1.tasks;

import co.edu.udea.calidad.ViveMedellinF1.interactions.FillRegistrationForm;
import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.AuthenticatedPageUI;
import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.HomePageUI;
import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.RegistrationPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegisterUser implements Task {

    private final String name;
    private final String lastname;
    private final String email;
    private final String password;
    private final String confirmPassword;

    public RegisterUser(String name, String lastname, String email, String password, String confirmPassword) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePageUI.REGISTER_BUTTON),
                FillRegistrationForm.withDetails(name, lastname, email, password, confirmPassword),
                Click.on(RegistrationPageUI.CREATE_ACCOUNT_BUTTON),
                WaitUntil.the(AuthenticatedPageUI.USERNAME_GREETING, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static RegisterUser withTheData(String name, String lastname, String email, String password, String confirmPassword) {
        return Tasks.instrumented(RegisterUser.class, name, lastname, email, password, confirmPassword);
    }
}