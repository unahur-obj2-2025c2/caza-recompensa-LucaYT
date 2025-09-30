package cazador;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.Profugo;
import ar.edu.unahur.obj2.Zona;

public abstract class Cazador {

    protected int experiencia;
    protected List<Profugo> profugosCapturados;
    protected List<Profugo> profugosIntimidados;
    //experiencia += (Mínimo valor de habilidad entre todos los intimidados) + (2 * prófugos capturados)

    public Cazador(int experiencia) {
        this.experiencia = experiencia;
        this.profugosCapturados = new ArrayList<>();
        this.profugosIntimidados = new ArrayList<>();
    }

    public void intentaCapturar(Profugo p, Zona z){
        if(this.puedeCapturar(p)){
            z.quitarProfugo(p);
            this.profugosCapturados.add(p);
        }
        else{
            this.intimidar(p);
            this.profugosIntimidados.add(p);
        }

        this.actualizarExperiencia();
    }

    public void actualizarExperiencia(){
        int minimoHabilidad = profugosIntimidados.stream().mapToInt(p -> p.getHabilidad()).min().orElse(0);
        this.experiencia += minimoHabilidad + 2 * (this.getCantCapturados());
    }

    public void intimidar(Profugo p){
        p.disminuirInocencia();
        intimidacionEspecifica(p);
    }

    public void capturarEnUnaZona(Zona z) {
        new ArrayList<>(z.getListaDeProfugos()).forEach(p -> this.intentaCapturar((Profugo) p, z));
    }

    protected abstract void intimidacionEspecifica(Profugo p);
    protected abstract boolean condicionEspecifica(Profugo p);
    
    public int getExperiencia(){
        return experiencia;
    }

    public int getCantCapturados(){
        return this.profugosCapturados.size();
    }

    //Condición general
    public Boolean puedeCapturar(Profugo p) {
        return this.experiencia > p.getInocencia() && condicionEspecifica(p);
    }

    public List<Profugo> getCapturados(){
        return this.profugosCapturados;
    }

    public void intentaCapturarTest(Profugo p){
        if(this.puedeCapturar(p)){
            this.profugosCapturados.add(p);
        }
        else{
            this.intimidar(p);
            this.profugosIntimidados.add(p);
        }

        this.actualizarExperiencia();
    }
}