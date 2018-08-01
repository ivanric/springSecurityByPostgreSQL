package app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Persona;
import app.servicio.IPersonaService;
import app.servicio.IProfesionService;

@RestController
@RequestMapping("/Personalizado/")
public class ControladorPersonalizado {
	@Autowired
	private IPersonaService personaService;
	@Autowired
	private IProfesionService profesionService;
	
	@RequestMapping(value="personas")
	public ResponseEntity<List<Persona>> getAllPersonas() {
		List<Persona> list = personaService.getAllPersonas();
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setProfesiones(profesionService.getProfesionesById(list.get(i).getIdper()));
		}
		
		return new ResponseEntity<List<Persona>>(list, HttpStatus.OK);
	}
}
