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

    // Constructor para recibir los datos
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
                // 1. Inicia el flujo desde el home
                Click.on(HomePageUI.REGISTER_BUTTON),

                // 2. Delega el llenado del formulario a la Interaction
                FillRegistrationForm.withDetails(name, lastname, email, password, confirmPassword),

                // 3. Hace clic en el botón final para crear la cuenta
                Click.on(RegistrationPageUI.CREATE_ACCOUNT_BUTTON),

                // 4. ¡LA ESPERA CLAVE! Espera hasta 10 segundos a que el saludo sea visible
                WaitUntil.the(AuthenticatedPageUI.USERNAME_GREETING, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    // Método estático para una lectura más fluida en los StepDefinitions
    public static RegisterUser withTheData(String name, String lastname, String email, String password, String confirmPassword) {
        return Tasks.instrumented(RegisterUser.class, name, lastname, email, password, confirmPassword);
    }
}