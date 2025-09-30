package ar.edu.unahur.obj2;

public class EntrenamientoElite implements IEntrenamientos{
    @Override
    public void efecto(Profugo p){
        p.esNervioso = false;
    }

    @Override
    public boolean esElite(){
        return true;
    }
}
