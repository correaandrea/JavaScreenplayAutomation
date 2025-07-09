package co.edu.udea.calidad.ViveMedellinF1.questions;

import co.edu.udea.calidad.ViveMedellinF1.userinterfaces.SectionUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class IsOnSection implements Question<Boolean> {

    private final String sectionName;

    public IsOnSection(String sectionName) {
        this.sectionName = sectionName;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Target validationTarget = getValidationTarget(sectionName);
        return validationTarget.resolveFor(actor).isVisible();
    }

    private Target getValidationTarget(String name) {
        switch (name.toLowerCase()) {
            case "eventos y actividades":
                return SectionUI.SECTION_EVENTOS_VISIBLE;
            case "comunidades":
                return SectionUI.SECTION_COMUNIDADES_VISIBLE;
            case "valoraciones":
                return SectionUI.SECTION_VALORACIONES_VISIBLE;
            default:
                throw new IllegalArgumentException("Sección no reconocida para validación: " + name);
        }
    }

    public static IsOnSection called(String sectionName) {
        return new IsOnSection(sectionName);
    }
}
