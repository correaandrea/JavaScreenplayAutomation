package co.edu.udea.calidad.ViveMedellinF1.questions;

import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.AuthenticatedPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

// Esta Question devuelve un String (el nombre de usuario)
public class UsernameDisplayed implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        // Usa la UI de la página autenticada para obtener el texto del saludo
        return Text.of(AuthenticatedPageUI.USERNAME_GREETING).answeredBy(actor);
    }

    // Método estático para que la lectura sea más fluida
    public static Question<String> is() {
        return new UsernameDisplayed();
    }
}
