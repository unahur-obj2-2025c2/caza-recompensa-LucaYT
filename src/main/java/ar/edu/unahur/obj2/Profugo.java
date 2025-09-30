package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.List;

public class Profugo {

    protected boolean esNervioso;
    protected int habilidad;
    protected int inocencia;
    private List<IEntrenamientos> entrenamientos;

    public Profugo(int inocencia, int habilidad, boolean esNervioso) {
        this.inocencia = inocencia;
        this.habilidad = habilidad;
        this.esNervioso = esNervioso;
        this.entrenamientos = new ArrayList<>();
    }

    public Integer getInocencia() {
        return inocencia;
    }

    public Integer getHabilidad() {
        return habilidad;
    }

    public boolean esNervioso() {
        return esNervioso;
    }

    public void disminuirInocencia() {
        boolean tieneProteccionLegal = this.entrenamientos.stream().anyMatch(e -> e.tieneProteccionLegal());

        if(tieneProteccionLegal){
            this.inocencia = Math.max(40, this.inocencia - 2);
        }
        else{
            this.inocencia = Math.max(0, this.inocencia - 2);
        }
    }

    public void disminuirHabilidad() {
        this.habilidad = Math.max(0, this.habilidad - 5);
    }

    public void volverseNervioso() {
        boolean esElite = this.entrenamientos.stream().anyMatch(e -> e.esElite());

        if (!esElite) {
            this.esNervioso = true;
        }
    }

    public void dejarDeSerNervioso() {
        this.esNervioso = false;
    }

    public void aniadirEntrenamiento(IEntrenamientos entrenamiento){
        if (this.entrenamientos.contains(entrenamiento)){}
        else{
            this.entrenamientos.add(entrenamiento);
            entrenamiento.efecto(this);
        }
    }
}
