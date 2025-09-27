package cazador;

import ar.edu.unahur.obj2.Profugo;

public class CazadorSigiloso {

    private int experiencia;

    public CazadorSigiloso(int experiencia) {
        this.experiencia = experiencia;
    }

    public Boolean puedeCapturar(Profugo p) {
        return this.experiencia > p.getInocencia() && this.experiencia > p.getHabilidad();
    }

}
