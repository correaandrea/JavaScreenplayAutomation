package co.edu.udea.calidad.ViveMedellinF1.stepdefinitions;

import co.edu.udea.calidad.ViveMedellinF1.interactions.ClickOnSection;
import co.edu.udea.calidad.ViveMedellinF1.questions.IsSectionVisible;
import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.HomePageUI;
import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.SectionUI;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class NavigationStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que ingreso desde el home")
    public void queIngresoDesdeElHome() {
        OnStage.theActorCalled("usuario").wasAbleTo(
                Open.url("http://localhost:3000")
        );
    }

    @When("hago clic en la sección {string}")
    public void hagoClicEnLaSeccion(String seccion) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickOnSection.named(getTargetFromName(seccion))
        );
    }

    @And("luego hago clic en la sección {string}")
    public void luegoHagoClicEnOtraSeccion(String seccion) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickOnSection.named(getTargetFromName(seccion))
        );
    }

    @And("finalmente hago clic en la sección {string}")
    public void finalmenteHagoClicEnOtraSeccion(String seccion) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickOnSection.named(getTargetFromName(seccion))
        );
    }

    @Then("debo estar en la sección {string}")
    public void deboEstarEnLaSeccion(String seccion) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(IsSectionVisible.on(getValidationTarget(seccion)), is(true))
        );
    }

    private net.serenitybdd.screenplay.targets.Target getTargetFromName(String name) {
        switch (name.toLowerCase()) {
            case "eventos y actividades":
                return HomePageUI.SECTION_EVENTOS;
            case "comunidades":
                return HomePageUI.SECTION_COMUNIDADES;
            case "valoraciones":
                return HomePageUI.SECTION_VALORACIONES;
            default:
                throw new IllegalArgumentException("Sección no reconocida: " + name);
        }
    }

    private net.serenitybdd.screenplay.targets.Target getValidationTarget(String name) {
        switch (name.toLowerCase()) {
            case "eventos y actividades":
                return SectionUI.SECTION_EVENTOS_VISIBLE;
            case "comunidades":
                return SectionUI.SECTION_COMUNIDADES_VISIBLE;
            case "valoraciones":
                return SectionUI.SECTION_VALORACIONES_VISIBLE;
            default:
                throw new IllegalArgumentException("Sección no reconocida para validación: " + name);
        }
    }
}
