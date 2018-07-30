package app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.IPersonaDAO;
import app.entity.Persona;

@Service
public class PersonaService implements IPersonaService {
	@Autowired 
	private IPersonaDAO personaDAO;
	@Override
	public Persona getPersonaById(int id) {
		Persona obj = personaDAO.getPersonaById(id);
		return obj;
	}	
	@Override
	public List<Persona> getAllPersonas(){
		return personaDAO.getAllPersonas();
	}
	
	@Override
	public void addPersona(Persona persona) {
		// TODO Auto-generated method stub
		personaDAO.addPersona(persona);
	}
	
	@Override
	public void updatePersona(Persona persona) {
		personaDAO.updatePersona(persona);
	}
	@Override
	public void deletePersona(int id) {
		personaDAO.deletePersona(id);
	}
	@Override
	public synchronized boolean personaExists(Persona persona){
        if (personaDAO.personaExists(persona.getCi())) {
          return true;
        } else {
          return false;
        }
	}
}
