package cazador;

import ar.edu.unahur.obj2.Cazador;
import ar.edu.unahur.obj2.Profugo;

public class CazadorRural extends Cazador{

    private int experiencia;

    public CazadorRural(int experiencia) {
        super(experiencia);
    }

    public Boolean puedeCapturar(Profugo p) {
        return this.experiencia > p.getInocencia() && this.condicionEspecifica(p);
    }

    @Override
    protected boolean condicionEspecifica(Profugo p) {
        return p.esNervioso();
    }

    protected void intimidacionEspecifica(Profugo p){
        p.volverseNervioso();
    }
}
