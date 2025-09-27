package cazador;

import ar.edu.unahur.obj2.Profugo;

public class CazadorUrbano {

    private int experiencia;

    public CazadorUrbano(int experiencia) {
        this.experiencia = experiencia;
    }

    public Boolean puedeCapturar(Profugo p) {
        return this.experiencia > p.getInocencia() && !p.esNervioso();
    }

}
