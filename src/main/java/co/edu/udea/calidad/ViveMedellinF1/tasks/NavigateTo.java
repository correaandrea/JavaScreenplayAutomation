package co.edu.udea.calidad.ViveMedellinF1.tasks;

import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.HomePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateTo implements Task {

    private final String sectionName;

    public NavigateTo(String sectionName) {
        this.sectionName = sectionName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target sectionTarget = getTargetFromName(sectionName);

        actor.attemptsTo(
                WaitUntil.the(sectionTarget, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(sectionTarget)
        );
    }

    private Target getTargetFromName(String name) {
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

    public static NavigateTo theSection(String sectionName) {
        return Tasks.instrumented(NavigateTo.class, sectionName);
    }
}
