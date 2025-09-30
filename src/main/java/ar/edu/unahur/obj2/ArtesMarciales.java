package ar.edu.unahur.obj2;

public class ArtesMarciales implements IEntrenamientos{
    
    @Override
    public void efecto(Profugo p){
        p.habilidad = Math.min(100, p.habilidad * 2);
    }
}
