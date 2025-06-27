package co.edu.udea.calidad.ViveMedellinF1.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class NavigateTask implements Task {

    private final Target navigationLink;

    public NavigateTask(Target navigationLink) {
        this.navigationLink = navigationLink;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(navigationLink, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(navigationLink)
        );
    }

    public static NavigateTask to(Target navigationLink) {
        return Tasks.instrumented(NavigateTask.class, navigationLink);
    }
}