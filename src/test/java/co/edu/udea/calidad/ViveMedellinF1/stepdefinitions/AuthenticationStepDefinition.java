package co.edu.udea.calidad.ViveMedellinF1.stepdefinitions;

import co.edu.udea.calidad.ViveMedellinF1.questions.AuthQuestion;
import co.edu.udea.calidad.ViveMedellinF1.tasks.AuthenticationTask;
import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.UserInterface; // Asegúrate de que esta importación sea correcta
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import org.openqa.selenium.WebDriver;

// Importar los Targets específicos desde UserInterface
import static co.edu.udea.calidad.ViveMedellinF1.userinterfaces.UserInterface.LOGIN_TITTLE; // Para el texto "undefined"
import static co.edu.udea.calidad.ViveMedellinF1.userinterfaces.UserInterface.USER_BUTTON; // Para el botón de usuario

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class AuthenticationStepDefinition {

    @Managed
    public WebDriver cdriver;
    private Actor usuario = new Actor("usuario");

    @Before
    public void config(){
        OnStage.setTheStage(new OnlineCast());
        usuario = OnStage.theActorCalled("usuario");
        usuario.can(BrowseTheWeb.with(cdriver));
    }

    @Given("que estoy en la página de inicio de sesión")
    public void queEstoyEnLaPaginaDeInicioDeSesion() {
        usuario.attemptsTo(Open.url("https://vive-medellin.vercel.app/Login"));
    }

    @When("ingreso mis credenciales {string} y {string} y doy click al boton iniciar sesion y doy click al boton de regreso")
    public void ingresoMisCredencialesYClickBotones(String email, String password) {
        usuario.attemptsTo(AuthenticationTask.loginWith(email, password));
    }

    @Then("debo poder ver el icono de usuario en la pantalla")
    public void deboPoderVerElIconoDeUsuarioEnLaPantalla() {
                usuario.should(
                        seeThat(AuthQuestion.login(), org.hamcrest.Matchers.is(true))
        );
    }
}



