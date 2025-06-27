package co.edu.udea.calidad.ViveMedellinF1.stepdefinitions;

import co.edu.udea.calidad.ViveMedellinF1.questions.CurrentPage;
import co.edu.udea.calidad.ViveMedellinF1.tasks.NavigateTask;
import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.UserInterface;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class NavigationStepDefinition {

    @Managed
    public WebDriver cdriver;
    private Actor usuario = new Actor("usuario");

    @Before
    public void config(){
        OnStage.setTheStage(new OnlineCast());
        usuario = OnStage.theActorCalled("usuario");
        usuario.can(BrowseTheWeb.with(cdriver));
    }

    @Given("que estoy en la página principal de la aplicación")
    public void queEstoyEnLaPaginaPrincipalDeLaAplicacion() {
        usuario.attemptsTo(Open.url("https://vive-medellin.vercel.app/"));
    }

    @Given("que estoy en la página de registro")
    public void queEstoyEnLaPaginaDeRegistro() {
        usuario.attemptsTo(Open.url("https://vive-medellin.vercel.app/Register"));
    }

    @When("navego a {string}")
    public void navegoA(String section) {
        Target navigationLink;
        switch (section) {
            case "Eventos y Actividades":
                navigationLink = UserInterface.EVENTOS_ACTIVIDADES_LINK;
                break;
            case "Comunidades":
                navigationLink = UserInterface.COMUNIDADES_LINK;
                break;
            case "Valoraciones":
                navigationLink = UserInterface.VALORACIONES_LINK;
                break;
            default:
                throw new IllegalArgumentException("Sección de navegación no reconocida: " + section);
        }
        usuario.attemptsTo(NavigateTask.to(navigationLink));
    }

    @When("navego a la página de {string} desde Login")
    public void navegoALaPaginaDeDesdeLogin(String page) {
        if ("Registro".equals(page)) {
            usuario.attemptsTo(NavigateTask.to(UserInterface.REGISTRO_LINK));
        } else {
            throw new IllegalArgumentException("Navegación desde Login a página no reconocida: " + page);
        }
    }

    @When("navego a la página de {string} desde Registro")
    public void navegoALaPaginaDeDesdeRegistro(String page) {
        if ("Login".equals(page)) {
            usuario.attemptsTo(NavigateTask.to(UserInterface.LOGIN_LINK_ON_REGISTER_PAGE));
        } else {
            throw new IllegalArgumentException("Navegación desde Registro a página no reconocida: " + page);
        }
    }

    @Then("debo ver la página de {string}")
    public void deboVerLaPaginaDe(String section) {
        Target pageIdentifier;
        switch (section) {
            case "Eventos y Actividades":
                pageIdentifier = UserInterface.EVENTOS_ACTIVIDADES_PAGE_TITLE;
                break;
            case "Comunidades":
                pageIdentifier = UserInterface.COMUNIDADES_PAGE_TITLE;
                break;
            case "Valoraciones":
                pageIdentifier = UserInterface.VALORACIONES_PAGE_TITLE;
                break;
            case "Login":
                pageIdentifier = UserInterface.LOGIN_BUTTON;
                break;
            case "Registro":
                pageIdentifier = UserInterface.REGISTRO_FORM;
                break;
            default:
                throw new IllegalArgumentException("Sección de verificación no reconocida: " + section);
        }
        usuario.should(
                seeThat(CurrentPage.is(pageIdentifier), is(true))
        );
    }
}