package cazador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unahur.obj2.Profugo;

public class JefeAgencia {
    private List<Cazador> listaCazadores;

    public JefeAgencia(List<Cazador> listaCazadores) {
        this.listaCazadores = new ArrayList<>();
    }

    public void aniadirCazador(Cazador c){
        this.listaCazadores.add(c);
    }

    public Cazador getElCazadorMasHabil(){
        return this.listaCazadores.stream().max(Comparator.comparing(c -> c.getCantCapturados())).orElse(null);
        // Lo mismo que el de abajo, con la diferencia que compara con la cantidad de capturados por cazador.
    }

    public Profugo getElProfugoMasHabilCapturado(){
        return this.todosLosCapturados().stream().max(Comparator.comparingInt(p -> p.getHabilidad())).orElse(null);
        // Agarra el número más alto de habilidad de todosLosCapturados, lleva el orElse null porque si la lista está vacía da error por nullPointerException.
    }

    public List<Profugo> todosLosCapturados() {
        return listaCazadores.stream().flatMap(c -> c.getCapturados().stream()).collect(Collectors.toList()); 
        // Hace un map de los capturados y automáticamente los pone en una lista.
    }
    
    public int getCantCapturados(){
        return this.todosLosCapturados().size();
    }
}
