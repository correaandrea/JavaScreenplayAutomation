package co.edu.udea.calidad.ViveMedellinF1.questions;

import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.LoginPageUI;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

public class IsOnLoginPage {
    public static Question<Boolean> now() {
        return actor -> WebElementQuestion.the(LoginPageUI.CONFIRM_LOGIN_BUTTON)
                .answeredBy(actor)
                .isVisible();
    }
}
