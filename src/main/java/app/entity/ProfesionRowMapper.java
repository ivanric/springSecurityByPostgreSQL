package app.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProfesionRowMapper implements RowMapper<Profesion>{
	@Override
	public Profesion mapRow(ResultSet row, int rowNum) throws SQLException {
		Profesion p= new Profesion();
		p.setIdper(row.getInt("idper"));
		p.setProfesion(row.getString("profesion"));
		p.setEstado(row.getInt("estado"));
		return p;
	}
}
