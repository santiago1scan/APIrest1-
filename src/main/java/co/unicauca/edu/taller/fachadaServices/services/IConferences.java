package co.unicauca.edu.taller.fachadaServices.services;


import java.util.List;
import co.unicauca.edu.taller.fachadaServices.DTO.ConferenceDTO;

public  interface IConferences {
    public List<ConferenceDTO> findAll();
    public ConferenceDTO findByID(int id);
    public ConferenceDTO save(ConferenceDTO conference);
    public ConferenceDTO update(int id, ConferenceDTO conference);
    public boolean delet(int id);
}