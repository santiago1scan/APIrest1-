package co.unicauca.edu.taller.capaAccesoADatos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class ConferenceEntity {
    private int id;
    private String name;
    private  int numArticles;
    public ConferenceEntity(){
        
    }
    
}
