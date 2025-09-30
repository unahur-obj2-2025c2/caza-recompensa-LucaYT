package ar.edu.unahur.obj2;

public class ProteccionLegal implements IEntrenamientos{
    @Override
    public void efecto(Profugo p){
        p.inocencia = Math.max(40, p.inocencia);
    }

    @Override
    public boolean tieneProteccionLegal(){
        return true;
    }
}
