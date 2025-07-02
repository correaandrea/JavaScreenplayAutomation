package co.edu.udea.calidad.ViveMedellinF1.stepdefinitions;

import co.edu.udea.calidad.ViveMedellinF1.interactions.FillRegistrationForm;
import co.edu.udea.calidad.ViveMedellinF1.questions.UsernameDisplayed;
import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.AuthenticatedPageUI;
import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.HomePageUI;
import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.RegistrationPageUI;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.core.IsEqual.equalTo;

public class RegisterStepDefinition {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("me encuentro en la pagina de inicio")
    public void meEncuentroEnLaPaginaDeInicio() {
        OnStage.theActorCalled("usuario").wasAbleTo(
                Open.url("http://localhost:3000")
        );
    }

    @When("navego a la pagina de registro")
    public void navegoALaPaginaDeRegistro() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(HomePageUI.REGISTER_BUTTON)
        );
    }

    @And("me registro con los datos: {string}, {string}, {string}, {string} y {string}")
    public void meRegistroConLosDatos(String nombre, String apellido, String correo, String contraseña, String confirmarContraseña) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FillRegistrationForm.withDetails(nombre, apellido, correo, contraseña, confirmarContraseña),
                Click.on(RegistrationPageUI.CREATE_ACCOUNT_BUTTON),
                WaitUntil.the(AuthenticatedPageUI.USERNAME_GREETING, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    @Then("deberia ser redirigido al home y ver mi sesion iniciada con el nombre {string}")
    public void deberiaVerMiSesionIniciadaConElNombre(String nombre) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(UsernameDisplayed.is(), equalTo(nombre))
        );
    }
}
