package co.edu.udea.calidad.ViveMedellinF1.stepdefinitions;

import co.edu.udea.calidad.ViveMedellinF1.questions.IsOnLoginPage;
import co.edu.udea.calidad.ViveMedellinF1.questions.UsernameDisplayed;
import co.edu.udea.calidad.ViveMedellinF1.tasks.LoginUser;
import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.AuthenticatedPageUI;
import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.HomePageUI;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginStepDefinition {

    @Managed
    WebDriver driver;

    private Actor usuario = Actor.named("usuario registrado");

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

    @When("hago clic en el botón de iniciar sesión")
    public void hagoClicEnElBotonDeIniciarSesion () {
        usuario.attemptsTo(Click.on(HomePageUI.LOGIN_BUTTON));
    }

    @And("ingreso el correo electrónico {string} y la contraseña {string}")
    public void ingresoElCorreoElectronicoYLaContraseña (String correo, String contraseña) {
        usuario.attemptsTo(LoginUser.withCredentials(correo, contraseña));
    }

    @Then("debería ver la sesión iniciada con el nombre {string}")
    public void deberiaVerLaSesionIniciadaConElNombre(String nombre) {
        usuario.attemptsTo
                (WaitUntil.the(AuthenticatedPageUI.USERNAME_GREETING, isVisible()).forNoMoreThan(10).seconds());
        usuario.should(seeThat(UsernameDisplayed.is(), equalTo(nombre)));
    }

    @Then("debería permanecer en la página de inicio de sesión")
    public void deberiaPermanecerEnLaPaginaDeInicioDeSesion() {
        usuario.should(seeThat(IsOnLoginPage.now(), is(true)));
    }
}


