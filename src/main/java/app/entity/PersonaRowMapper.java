package app.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import app.dao.IProfesionDAO;
import app.servicio.IProfesionService;


public class PersonaRowMapper implements RowMapper<Persona>{
	@Override
	public Persona mapRow(ResultSet row, int rowNum) throws SQLException {
		Persona p= new Persona();
		p.setIdper(row.getInt("idper"));
		p.setCi(row.getInt("ci"));
		p.setNombre(row.getString("nombre"));
		p.setAp(row.getString("ap"));
		p.setAm(row.getString("am"));
		p.setDireccion(row.getString("direccion"));	
		return p;
	}
}
