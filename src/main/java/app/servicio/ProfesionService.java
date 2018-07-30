package app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.IProfesionDAO;
import app.entity.Profesion;

@Service
public class ProfesionService implements IProfesionService{
	@Autowired
	private IProfesionDAO iprofesionDAO;
	
	@Override
	public List<Profesion> getProfesionesById(int id){
		return iprofesionDAO.getAllProfesiones(id);
	}
}
