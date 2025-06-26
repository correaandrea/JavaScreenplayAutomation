package co.edu.udea.calidad.ViveMedellinF1.stepdefinitions;

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
import org.openqa.selenium.WebDriver;

public class AuthenticationStepDefinition {

    @Managed
    public WebDriver cdriver;
    private Actor usuario = new Actor("usuario");

    @Before
    public void config(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario");
        usuario.can(BrowseTheWeb.with(cdriver));
    }

    @Given("que estoy en la página de inicio de sesión")
    public void queEstoyEnLaPáginaDeInicioDeSesión() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("ingreso {string} en el campo de correo electrónico")
    public void ingresoEnElCampoDeCorreoElectrónico(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("ingreso {string} en el campo de contraseña")
    public void ingresoEnElCampoDeContraseña(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("hago clic en el botón {string}")
    public void hagoClicEnElBotón(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("debería seguir en la página de inicio de sesión")
    public void deberíaSeguirEnLaPáginaDeInicioDeSesión() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("no debería ver ningún mensaje de error explícito")
    public void noDeberíaVerNingúnMensajeDeErrorExplícito() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
