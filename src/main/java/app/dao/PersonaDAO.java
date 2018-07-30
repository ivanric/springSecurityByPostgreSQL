package app.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.entity.Persona;
import app.entity.PersonaRowMapper;
@Transactional
@Repository
public class PersonaDAO implements IPersonaDAO{
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	@Override
	public Persona getPersonaById(int personaId) {
		String sql = "SELECT * FROM persona WHERE idper = ?";
		RowMapper<Persona> rowMapper = new BeanPropertyRowMapper<Persona>(Persona.class);
		Persona Persona = jdbcTemplate.queryForObject(sql, rowMapper, personaId);
		return Persona;
	}
	@Override
	public List<Persona> getAllPersonas() {
		String sql = "SELECT * FROM persona";
                //RowMapper<Persona> rowMapper = new BeanPropertyRowMapper<Persona>(Persona.class);
		RowMapper<Persona> rowMapper = new PersonaRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}	
	@Override
	public void addPersona(Persona Persona) {
		//Add Persona
		String sql = "INSERT INTO persona (idper,ci,nombre,ap,am,direccion) values (?,?,?,?,?,?)";
		jdbcTemplate.update(sql, Persona.getIdper(), Persona.getCi(), Persona.getNombre(),Persona.getAp(),Persona.getAm(),Persona.getDireccion());
		
		//Fetch Persona id
		sql = "SELECT idper FROM persona WHERE ci=?";
		int PersonaIdPer = jdbcTemplate.queryForObject(sql, Integer.class, Persona.getCi());
		
		//Set Persona id 
		Persona.setIdper(PersonaIdPer);
	}
	@Override
	public void updatePersona(Persona Persona) {
		String sql = "UPDATE persona SET nombre=?, ap=?, am=? WHERE idper=?";
		jdbcTemplate.update(sql, Persona.getNombre(), Persona.getAp(),Persona.getAm(),Persona.getIdper());
	}
	@Override
	public void deletePersona(int PersonaId) {
		String sql = "DELETE FROM persona WHERE idper=?";
		jdbcTemplate.update(sql, PersonaId);
	}
	@Override
	public boolean personaExists(int ci) {
		String sql = "SELECT count(*) FROM persona WHERE ci=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, ci);
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
}
