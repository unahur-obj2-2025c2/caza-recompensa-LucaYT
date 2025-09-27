package cazador;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.Profugo;

public class CazadorTest {
    @Test
    void urbanoCapturaSiExperienciaMayorYNoNervioso() {
        CazadorUrbano c = new CazadorUrbano(60);
        Profugo p = new Profugo(40,70,false);
        assertTrue(c.puedeCapturar(p));
    }

    @Test
    void ruralNoCapturaSiNoEsNervioso() {
        CazadorRural c = new CazadorRural(70);
        Profugo p = new Profugo(40,70,false);
        assertFalse(c.puedeCapturar(p));
    }

    @Test
    void sigilosoNoCapturaSiHabilidadAlta() {
        CazadorSigiloso c = new CazadorSigiloso(80);
        Profugo p = new Profugo(20,90,true);
        assertFalse(c.puedeCapturar(p));
    }
}
