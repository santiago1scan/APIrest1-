package co.unicauca.edu.taller.capaAccesoADatos.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.unicauca.edu.taller.capaAccesoADatos.models.ConferenceEntity;

@Service
public class ConferenceRepository {
    private ArrayList<ConferenceEntity> listConferences;
    
    public ConferenceRepository(){
        this.listConferences = new  ArrayList<ConferenceEntity>();
    }

    public List<ConferenceEntity> findAll(){
        System.out.println("Listas de Conferencias: ");
        return this.listConferences;
    }
    public ConferenceEntity findByind(int id){
        System.out.println("Busqueda por id: ");
        ConferenceEntity obj = null;
        for(ConferenceEntity conference: listConferences){
            if(conference.getId() == id){
                obj = conference;
                break;
            }
        }
        return obj;
    }
    public ConferenceEntity update(int  id, ConferenceEntity conference){
        System.out.println("Invocando a actualiazr articulo: ");
        ConferenceEntity obj = null;
        for(int i = 0; i  < this.listConferences.size(); i++){
            obj = conference;
            listConferences.set(i, obj);
            break;
        }
        return obj;
    }

    public boolean delete(int id){
        System.out.println("Invocando a eliminar un articulo");
        for(int i = 0; i<this.listConferences.size(); i++){
            this.listConferences.remove(id);
            return true;
        }
        return false;
    }
    public ConferenceEntity save(ConferenceEntity conference){
        System.out.println("invocando almacenar articulo");
        ConferenceEntity objConferenceEntity = null;
        if(this.listConferences.add(conference)){
            objConferenceEntity= conference ;
        }
        return objConferenceEntity;
    }
}