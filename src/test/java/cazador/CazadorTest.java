package cazador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.Profugo;
import ar.edu.unahur.obj2.Zona;

public class CazadorTest {
    @Test
    public void urbanoCapturaSiExperienciaMayorYNoNervioso() {
        CazadorUrbano c = new CazadorUrbano(60);
        Profugo p = new Profugo(40,50,false);
        assertTrue(c.puedeCapturar(p));
    }

    @Test
    public void ruralCapturaSiEsNervioso() {
        CazadorRural c = new CazadorRural(70);
        Profugo p = new Profugo(40,70,true);
        assertTrue(c.puedeCapturar(p));
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

    @Test
    public void cazadorSigilosoTiene1Capturado(){
        CazadorSigiloso c = new CazadorSigiloso(70);
        Profugo p = new Profugo(50,50,true);
        c.intentaCapturarTest(p);
        assertEquals(1, c.getCantCapturados());
    }

    @Test
    public void cazadorExperienciaSubeA112(){
        CazadorUrbano c = new CazadorUrbano(70);
        Profugo p = new Profugo(50,20,true);
        c.intentaCapturarTest(p);
        c.intentaCapturarTest(p);
        assertEquals(112, c.getExperiencia());
    }

    @Test
    public void cazadorCaptura2ProfugosEnUnaZona(){
        CazadorUrbano c = new CazadorUrbano(70);

        Zona z = new Zona(null);

        Profugo p = new Profugo(50,20,true);
        Profugo s = new Profugo(50,20,false);

        z.aniadirProfugo(p);
        z.aniadirProfugo(s);

        c.capturarEnUnaZona(z);
        c.capturarEnUnaZona(z);

        assertEquals(0, z.getProfugos());
    }

    @Test
    public void agenciaQuiereVerloTodo(){
        CazadorUrbano cu = new CazadorUrbano(70);
        CazadorSigiloso cs = new CazadorSigiloso(70);

        Zona z = new Zona(null);
        Profugo p = new Profugo(40,90,false);
        Profugo pp = new Profugo(40,50,false);
        Profugo s = new Profugo(40,20,true);

        JefeAgencia j = new JefeAgencia(null);

        z.aniadirProfugo(p);
        z.aniadirProfugo(s);
        z.aniadirProfugo(pp);
        j.aniadirCazador(cu);
        j.aniadirCazador(cs);

        cu.capturarEnUnaZona(z);
        cs.capturarEnUnaZona(z);

        assertEquals(3, j.getCantCapturados());
        assertEquals(p, j.getElProfugoMasHabilCapturado());
        assertEquals(cu, j.getElCazadorMasHabil());
    }
}
