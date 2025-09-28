package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.List;

public class Zona {
    protected List<Profugo> profugos;

    public Zona(List<Profugo> profugos) {
        this.profugos = new ArrayList<>();
    }

    public void aniadirProfugo(Profugo p){
        this.profugos.add(p);
    }

    public void quitarProfugo(Profugo p){
        this.profugos.remove(p);
    }

    public Integer getProfugos() {
        return profugos.size();
    }

    public List<Profugo> getListaDeProfugos() {
        return profugos;
    }

}
