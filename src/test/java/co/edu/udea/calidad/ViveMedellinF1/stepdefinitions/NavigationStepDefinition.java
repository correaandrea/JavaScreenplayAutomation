package co.edu.udea.calidad.ViveMedellinF1.stepdefinitions;

import co.edu.udea.calidad.ViveMedellinF1.questions.IsOnLoginPage;
import co.edu.udea.calidad.ViveMedellinF1.questions.IsOnRegistrationPage;
import co.edu.udea.calidad.ViveMedellinF1.questions.IsOnSection;
import co.edu.udea.calidad.ViveMedellinF1.tasks.NavigateTo;
import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.CoreMatchers.is;

public class NavigationStepDefinition {

    @Managed
    WebDriver driver;

    private Actor usuario = Actor.named("usuario");

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

    @And("hago clic en el enlace de registro")
    public void hagoClicEnElEnlaceDeRegistro() {
        usuario.attemptsTo(Click.on(LoginPageUI.REGISTER_LINK),
                WaitUntil.the(RegistrationPageUI.CREATE_ACCOUNT_BUTTON, isVisible()).forNoMoreThan(10).seconds());
    }

    @When("hago clic en el enlace de iniciar sesión")
    public void hagoClicEnElEnlaceDeIniciarSesion() {
        usuario.attemptsTo(Click.on(RegistrationPageUI.LOGIN_LINK),
                WaitUntil.the(LoginPageUI.CONFIRM_LOGIN_BUTTON, isVisible()).forNoMoreThan(10).seconds());
    }

    @Then("debería estar en la página de registro")
    public void deberiaEstarEnLaPaginaDeRegistro() {
        usuario.should(seeThat(IsOnRegistrationPage.now(), is(true)));
    }

    @Then("debería estar en la página de inicio de sesión")
    public void deberiaEstarEnLaPaginaDeInicioDeSesion() {
        usuario.should(seeThat(IsOnLoginPage.now(), is(true)));
    }

    @When("hago clic en la sección {string}")
    public void hagoClicEnLaSeccion(String seccion) {usuario.attemptsTo(NavigateTo.theSection(seccion));
    }

    @And("luego hago clic en la sección {string}")
    public void luegoHagoClicEnOtraSeccion(String seccion) {
        usuario.attemptsTo(NavigateTo.theSection(seccion));
    }

    @And("finalmente hago clic en la sección {string}")
    public void finalmenteHagoClicEnOtraSeccion(String seccion) {
        usuario.attemptsTo(NavigateTo.theSection(seccion));
    }

    @Then("debo estar en la sección {string}")
    public void deboEstarEnLaSeccion(String seccion) {
        usuario.should(seeThat(IsOnSection.called(seccion), is(true)));
    }
}

