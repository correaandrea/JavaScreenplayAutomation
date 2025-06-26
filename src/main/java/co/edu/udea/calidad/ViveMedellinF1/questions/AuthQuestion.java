package co.edu.udea.calidad.ViveMedellinF1.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.edu.udea.calidad.ViveMedellinF1.userinterfaces.UserInterface.LOGIN_TITTLE;


public class AuthQuestion implements Question <Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String temporal = Text.of(LOGIN_TITTLE).answeredBy(actor);
        if (temporal.contains("undefined")){
            return true;
        } else return false;
    }

    public static AuthQuestion login() {
        return new AuthQuestion();
    }
}