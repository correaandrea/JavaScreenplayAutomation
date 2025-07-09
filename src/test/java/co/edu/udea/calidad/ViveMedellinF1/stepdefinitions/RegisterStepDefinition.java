package co.edu.udea.calidad.ViveMedellinF1.stepdefinitions;

import co.edu.udea.calidad.ViveMedellinF1.tasks.RegisterUser;
import co.edu.udea.calidad.ViveMedellinF1.questions.UsernameDisplayed;
import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.HomePageUI;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class RegisterStepDefinition {

    @Managed
    WebDriver driver;

    private Actor usuario = Actor.named("usuario nuevo");

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        usuario.can(BrowseTheWeb.with(driver));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("que me encuentro en la página de inicio")
    public void queMeEncuentroEnLaPaginaDeInicio() {
        usuario.wasAbleTo(Open.url("http://localhost:3000"));
    }

    @When("navego a la pagina de registro")
    public void navegoALaPaginaDeRegistro() {
        usuario.attemptsTo(Click.on(HomePageUI.REGISTER_BUTTON));
    }

    @And("me registro con los datos: {string}, {string}, {string}, {string} y {string}")
    public void meRegistroConLosDatos(String nombre, String apellido, String correo, String contraseña, String confirmarContraseña) {
        usuario.attemptsTo(RegisterUser.withTheData(nombre, apellido, correo, contraseña, confirmarContraseña)
        );
    }

    @Then("deberia ser redirigido al home y ver mi sesion iniciada con el nombre {string}")
    public void deberiaVerMiSesionIniciadaConElNombre(String nombre) {
        usuario.should(seeThat(UsernameDisplayed.is(), equalTo(nombre))
        );
    }
}