package app.servicio;

import java.util.List;

import app.entity.Persona;
public interface IPersonaService {
    List<Persona> getAllPersonas();
    Persona getPersonaById(int Id);
    void addPersona(Persona persona);
    void updatePersona(Persona persona);
    void deletePersona(int Id);
    boolean personaExists(Persona persona);
}
