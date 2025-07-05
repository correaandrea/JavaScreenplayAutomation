package co.edu.udea.calidad.ViveMedellinF1.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SectionUI {
    public static final Target SECTION_EVENTOS_VISIBLE = Target.the("eventos content").located(By.xpath("/html/body/div/div[2]/div/div/div[3]/div/h1"));
    public static final Target SECTION_COMUNIDADES_VISIBLE = Target.the("comunidades content").located(By.xpath("/html/body/div/div[2]/div/div"));
    public static final Target SECTION_VALORACIONES_VISIBLE = Target.the("valoraciones content").located(By.xpath("/html/body/div/div[2]/div/div"));
}
