package co.edu.udea.calidad.ViveMedellinF1.questions;

import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.RegistrationPageUI;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

public class IsOnRegistrationPage {
    public static Question<Boolean> now() {
        return actor -> WebElementQuestion.the(RegistrationPageUI.CREATE_ACCOUNT_BUTTON)
                .answeredBy(actor)
                .isVisible();
    }
}

