package ar.edu.unahur.obj2;

public class Profugo {

    private boolean esNervioso;
    private int habilidad;
    private int inocencia;

    public Profugo(int inocencia, int habilidad, boolean esNervioso) {
        this.inocencia = inocencia;
        this.habilidad = habilidad;
        this.esNervioso = esNervioso;
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
        this.inocencia = Math.max(0, this.inocencia - 2);
    }

    public void disminuirHabilidad() {
        this.habilidad = Math.max(0, this.habilidad - 5);
    }

    public void volverseNervioso() {
        this.esNervioso = true;
    }

    public void dejarDeSerNervioso() {
        this.esNervioso = false;
    }

}
