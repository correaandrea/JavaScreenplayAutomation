package co.edu.udea.calidad.ViveMedellinF1.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickOnSection implements Interaction {

    private final Target section;

    public ClickOnSection(Target section) {
        this.section = section;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(section, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(section)
        );
    }

    public static ClickOnSection named(Target section) {
        return Tasks.instrumented(ClickOnSection.class, section);
    }
}

