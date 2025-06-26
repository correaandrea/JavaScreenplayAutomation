package co.edu.udea.calidad.ViveMedellinF1.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import co.edu.udea.calidad.ViveMedellinF1.interactions.AuthInteraction;

public class AuthenticationTask implements Task {

    private final String email;
    private final String password;

    public AuthenticationTask(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                AuthInteraction.withCredentials(email, password)
        );
    }

    public static AuthenticationTask loginWith(String email, String password) {
        return Tasks.instrumented(AuthenticationTask.class, email, password);
    }
}