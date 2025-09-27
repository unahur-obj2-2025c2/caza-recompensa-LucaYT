package cazador;

import ar.edu.unahur.obj2.Cazador;
import ar.edu.unahur.obj2.Profugo;

public class CazadorSigiloso extends Cazador{

    private int experiencia;

    public CazadorSigiloso(int experiencia) {
        super(experiencia);
    }

    public Boolean puedeCapturar(Profugo p) {
        return this.experiencia > p.getInocencia() && this.condicionEspecifica(p);
    }

    @Override
    protected boolean condicionEspecifica(Profugo p) {
        return this.experiencia > p.getHabilidad();
    }

    public void intimidar(Profugo p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'intimidar'");
    }

}
