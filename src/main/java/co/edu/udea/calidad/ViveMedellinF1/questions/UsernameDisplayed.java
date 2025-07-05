package co.edu.udea.calidad.ViveMedellinF1.questions;

import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.AuthenticatedPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;


public class UsernameDisplayed implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(AuthenticatedPageUI.USERNAME_GREETING).answeredBy(actor);
    }

    public static Question<String> is() {
        return new UsernameDisplayed();
    }
}
