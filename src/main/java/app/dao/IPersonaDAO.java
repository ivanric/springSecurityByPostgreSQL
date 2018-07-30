package app.dao;

import java.util.List;

import app.entity.Persona;
public interface IPersonaDAO {
	List<Persona> getAllPersonas();
    Persona getPersonaById(int personaId);
    void addPersona(Persona persona);
    void updatePersona(Persona persona);
    void deletePersona(int personaId);
    boolean personaExists(int ci);
    
}
