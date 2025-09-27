package cazador;

import ar.edu.unahur.obj2.Profugo;

public class CazadorRural {

    private int experiencia;

    public CazadorRural(int experiencia) {
        this.experiencia = experiencia;
    }

    public boolean puedeCapturar(Profugo p) {
        return this.experiencia > p.getInocencia() && p.esNervioso();
    }

}
