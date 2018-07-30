package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import app.entity.Persona;
import app.servicio.IPersonaService;
import app.servicio.IProfesionService;
import app.servicio.ProfesionService;

@RestController
@RequestMapping("/demo/")
public class PersonaController {
	@Autowired
	private IPersonaService personaService;
	@Autowired
	private IProfesionService profesionService;
	
	
	@RequestMapping("persona/{id}")
	public ResponseEntity<Persona> getPersonById(@PathVariable("id") Integer id) {// @PathVariable referencia a {id} de tipo Integer
		Persona persona = personaService.getPersonaById(id);
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	@RequestMapping(value="personas")
	public ResponseEntity<List<Persona>> getAllPersonas() {
		List<Persona> list = personaService.getAllPersonas();
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setProfesiones(profesionService.getProfesionesById(list.get(i).getIdper()));
		}
		
		return new ResponseEntity<List<Persona>>(list, HttpStatus.OK);
	}
	@RequestMapping(value="persona",method=RequestMethod.POST)
	public ResponseEntity<Void> addPerson(@RequestBody Persona persona, UriComponentsBuilder builder) {
        System.out.println("Persona: "+persona.toString());
		personaService.addPersona(persona);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@RequestMapping(value="persona",method=RequestMethod.PUT)
	public ResponseEntity<Persona> updatePerson(@RequestBody Persona persona) {
		personaService.updatePersona(persona);
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	@RequestMapping(value="persona/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePerson(@PathVariable("id") Integer id) {
		personaService.deletePersona(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}	
	@RequestMapping(value="existe",method=RequestMethod.POST)
	public ResponseEntity<Persona> existePerson(@RequestBody Persona persona) {
//		public ResponseEntity<Persona> existePerson(@RequestBody Persona persona, UriComponentsBuilder builder) {
        System.out.println("Persona: "+persona.toString());
		boolean flag = personaService.personaExists(persona);
        System.out.println("status: "+flag);
        Persona p=null;
        if (flag == false) {
        	return new ResponseEntity<Persona>(p,HttpStatus.CONFLICT);
        }else {
        	p = personaService.getPersonaById(persona.getIdper());
        }
        
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/persona/{id}").buildAndExpand(persona.getIdper()).toUri());
//        return new ResponseEntity<Persona>(headers, HttpStatus.CREATED);
        return new ResponseEntity<Persona>(p, HttpStatus.OK);
	}
}
