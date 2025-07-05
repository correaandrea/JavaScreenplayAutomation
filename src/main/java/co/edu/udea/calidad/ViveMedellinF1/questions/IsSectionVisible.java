package co.edu.udea.calidad.ViveMedellinF1.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class IsSectionVisible implements Question<Boolean> {

    private final Target sectionElement;

    public IsSectionVisible(Target sectionElement) {
        this.sectionElement = sectionElement;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return sectionElement.resolveFor(actor).isVisible();
    }

    public static IsSectionVisible on(Target sectionElement) {
        return new IsSectionVisible(sectionElement);
    }
}

