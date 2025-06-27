package co.edu.udea.calidad.ViveMedellinF1.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

public class CurrentPage implements Question<Boolean> {

    private final Target pageIdentifier;

    public CurrentPage(Target pageIdentifier) {
        this.pageIdentifier = pageIdentifier;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return WebElementQuestion.the(pageIdentifier).answeredBy(actor).isCurrentlyVisible();
    }

    public static CurrentPage is(Target pageIdentifier) {
        return new CurrentPage(pageIdentifier);
    }
}
