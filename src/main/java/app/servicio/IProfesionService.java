package app.servicio;

import java.util.List;

import app.entity.Profesion;

public interface IProfesionService {
	   List<Profesion> getProfesionesById(int id);
}
