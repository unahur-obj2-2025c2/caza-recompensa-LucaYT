package cazador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.Profugo;

public class CazadorTest {
    @Test
    public void urbanoCapturaSiExperienciaMayorYNoNervioso() {
        CazadorUrbano c = new CazadorUrbano(60);
        Profugo p = new Profugo(40,70,false);
        assertTrue(c.puedeCapturar(p));
    }

    @Test
    public void ruralNoCapturaSiNoEsNervioso() {
        CazadorRural c = new CazadorRural(70);
        Profugo p = new Profugo(40,70,false);
        assertFalse(c.puedeCapturar(p));
    }

    @Test
    public void sigilosoNoCapturaSiHabilidadAlta() {
        CazadorSigiloso c = new CazadorSigiloso(80);
        Profugo p = new Profugo(20,90,true);
        assertFalse(c.puedeCapturar(p));
    }

    
    @Test
    public void urbanoIntimidaYDejaDeSerNerviosoYDisminuyeInocencia(){
        CazadorUrbano c = new CazadorUrbano(70);
        Profugo p = new Profugo(50,50,true);
        c.intimidar(p);
        assertFalse(p.esNervioso());
        assertEquals(Integer.valueOf(48),p.getInocencia());
    }

    @Test
    public void ruralIntimidaYSeVuelveNerviosoYDisminuyeInocencia(){
        CazadorRural c = new CazadorRural(70);
        Profugo p = new Profugo(50,50,true);
        c.intimidar(p);
        assertTrue(p.esNervioso());
        assertEquals(Integer.valueOf(48),p.getInocencia());
    }

    @Test
    public void sigilosoIntimidaYDejaDeSerNerviosoYDisminuyeInocencia(){
        CazadorSigiloso c = new CazadorSigiloso(70);
        Profugo p = new Profugo(50,50,true);
        c.intimidar(p);
        assertEquals(Integer.valueOf(45),p.getHabilidad());
        assertEquals(Integer.valueOf(48),p.getInocencia());
    }
}
