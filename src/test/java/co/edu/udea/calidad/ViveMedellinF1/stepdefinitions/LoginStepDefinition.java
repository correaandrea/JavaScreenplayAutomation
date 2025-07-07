package co.edu.udea.calidad.ViveMedellinF1.stepdefinitions;

import co.edu.udea.calidad.ViveMedellinF1.interactions.FillLoginForm;
import co.edu.udea.calidad.ViveMedellinF1.questions.UsernameDisplayed;
import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.AuthenticatedPageUI;
import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.HomePageUI;
import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.LoginPageUI;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.core.IsEqual.equalTo;

public class LoginStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que me encuentro en la página de inicio")
    public void queMeEncuentroEnLaPaginaDeInicio() {
        OnStage.theActorCalled("usuario").wasAbleTo(
                Open.url("http://localhost:3000")
        );
    }

    @When("hago clic en el botón de iniciar sesión")
    public void hagoClicEnElBotonDeIniciarSesion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(HomePageUI.LOGIN_BUTTON)
        );
    }

    @And("ingreso el correo electrónico {string} y la contraseña {string}")
    public void ingresoElCorreoYLaContraseña(String correo, String contraseña) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FillLoginForm.withCredentials(correo, contraseña)
        );
    }

    @And("hago clic en el botón de iniciar sesión para confirmar")
    public void hagoClicEnElBotonParaConfirmar() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(LoginPageUI.CONFIRM_LOGIN_BUTTON),
                WaitUntil.the(AuthenticatedPageUI.USERNAME_GREETING, isVisible()).forNoMoreThan(10).seconds()
        );
    }

}


