package cazador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.ArtesMarciales;
import ar.edu.unahur.obj2.EntrenamientoElite;
import ar.edu.unahur.obj2.Profugo;
import ar.edu.unahur.obj2.ProteccionLegal;
import ar.edu.unahur.obj2.Zona;

public class ProfugoTest {
    @Test
    public void guardaYDevuelveAtributos(){
        Profugo p = new Profugo(50,60, true);
        assertEquals(Integer.valueOf(50), p.getInocencia());
        assertEquals(Integer.valueOf(60), p.getHabilidad());
        assertTrue(p.esNervioso());
    }

    @Test
    public void disminuirInocenciaNoBajaDeCero(){
        Profugo p = new Profugo(1,30,false);
        p.disminuirInocencia();
        p.disminuirInocencia();
        assertEquals(Integer.valueOf(0), p.getInocencia());
    }

    @Test
    public void disminuirHabilidadNoBajaDeCero(){
        Profugo p = new Profugo(30,1,false);
        p.disminuirHabilidad();
        p.disminuirHabilidad();
        assertEquals(Integer.valueOf(0), p.getHabilidad());
    }

    @Test
    public void profugoEsArtistaMarcialYDuplicaHabilidad(){
        Profugo p = new Profugo(40, 40, false);

        p.aniadirEntrenamiento(new ArtesMarciales());

        assertEquals(80, p.getHabilidad());
    }

    @Test
    public void profugoEsEliteYNoSeVuelveNervioso(){
        Profugo p = new Profugo(40, 40, true);

        p.aniadirEntrenamiento(new EntrenamientoElite());

        p.volverseNervioso();
        assertEquals(false, p.esNervioso());
    }

    @Test
    public void profugoTieneCoverturaLegalYNoBajaDe40(){
        CazadorUrbano c = new CazadorUrbano(70);

        Zona z = new Zona(null);
        Profugo p = new Profugo(40,20,true);

        z.aniadirProfugo(p);
        p.aniadirEntrenamiento(new ProteccionLegal());

        c.intentaCapturar(p, z);
        
        assertEquals(40, p.getInocencia());
    }
}
