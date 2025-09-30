package ar.edu.unahur.obj2;

public interface IEntrenamientos {
    public void efecto(Profugo p);
    default boolean esElite() {
        return false;
    }
    default boolean tieneProteccionLegal(){
        return false;
    }
}
