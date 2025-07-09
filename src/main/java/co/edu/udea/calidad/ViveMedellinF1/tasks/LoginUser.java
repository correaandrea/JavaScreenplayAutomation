package co.edu.udea.calidad.ViveMedellinF1.tasks;

import co.edu.udea.calidad.ViveMedellinF1.interactions.FillLoginForm;
import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.LoginPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class LoginUser implements Task {

    private final String email;
    private final String password;

    public LoginUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                FillLoginForm.withCredentials(email, password),
                Click.on(LoginPageUI.CONFIRM_LOGIN_BUTTON)
        );
    }

    public static LoginUser withCredentials(String email, String password) {
        return Tasks.instrumented(LoginUser.class, email, password);
    }
}


