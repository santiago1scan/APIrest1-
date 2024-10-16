package co.unicauca.edu.taller.fachadaServices.services;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.TypeToken;

import co.unicauca.edu.taller.capaAccesoADatos.models.ConferenceEntity;
import co.unicauca.edu.taller.capaAccesoADatos.repositories.ConferenceRepository;
import co.unicauca.edu.taller.fachadaServices.DTO.ConferenceDTO;


@Service
public class ConferenceServices implements IConferences{
     @Autowired
     private ConferenceRepository conferenceRepository;

     @Autowired
     private ModelMapper ModelMapper;
   
     public ConferenceServices(ConferenceRepository ConferenceRepository, ModelMapper model ){
        this.ModelMapper = model;
        this.conferenceRepository = ConferenceRepository;
        createConferences();
     }

     @Override
     public List<ConferenceDTO> findAll(){
        List<ConferenceEntity> conferencesEntity = this.conferenceRepository.findAll();
        List<ConferenceDTO> conferencesDTO = this.ModelMapper.map(conferencesEntity, new TypeToken<List<ConferenceDTO>>() {
		}.getType());
        return conferencesDTO;
     }
     @Override
     public ConferenceDTO findByID(int id){
         ConferenceEntity conferenceEntity = this.conferenceRepository.findByind(id);
         ConferenceDTO conferenceDTO = this.ModelMapper.map(conferenceEntity, ConferenceDTO.class);
         return conferenceDTO;
     }
     @Override
     public ConferenceDTO save(ConferenceDTO conference){
         ConferenceEntity conferenceEntity = this.ModelMapper.map(conference, ConferenceEntity.class);
         ConferenceEntity objConferenceEntity = this.conferenceRepository.save(conferenceEntity);
         ConferenceDTO conferenceDTO = this.ModelMapper.map(objConferenceEntity, ConferenceDTO.class);
         return conferenceDTO;
     }   
     @Override
     public ConferenceDTO update(int id, ConferenceDTO conference){
         ConferenceEntity conferenceEntity = this.ModelMapper.map(conference, ConferenceEntity.class);
         ConferenceEntity clienteEntityUpdate = this.conferenceRepository.update(id, conferenceEntity);
         ConferenceDTO  articuleDTO = this.ModelMapper.map(clienteEntityUpdate, ConferenceDTO.class);
         return articuleDTO;
     }
     @Override
     public boolean delet(int id){
      return this.conferenceRepository.delete(id);
     }
   private void createConferences(){
      this.conferenceRepository.save(new ConferenceEntity(1, "Articulo 1" ,2));
      this.conferenceRepository.save(new ConferenceEntity(2, "Articulo 2" ,2));
      this.conferenceRepository.save(new ConferenceEntity(3, "Articulo 12" ,2));
      this.conferenceRepository.save(new ConferenceEntity(4, "Articulo 11" ,2));
      this.conferenceRepository.save(new ConferenceEntity(14, "Articulo 10" ,2));
      
  }

     
}
