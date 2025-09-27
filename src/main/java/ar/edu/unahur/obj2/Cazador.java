package ar.edu.unahur.obj2;

public abstract class Cazador {
    protected int experiencia;


    public Cazador(int experiencia) {
        this.experiencia = experiencia;
    }

    //Condición general
    public Boolean puedeCapturar(Profugo p) {
        return this.experiencia > p.getInocencia() && condicionEspecifica(p);
    }

    protected abstract boolean condicionEspecifica(Profugo p);

    public void capturarOIntimidar(Profugo p){
        if(this.puedeCapturar(p)){
            
        }
    }

    public void intimidar(Profugo p){
        p.disminuirInocencia();
        intimidacionEspecifica(p);
    }

    protected abstract void intimidacionEspecifica(Profugo p);
}