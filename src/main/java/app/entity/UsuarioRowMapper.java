package app.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsuarioRowMapper implements RowMapper<Usuario>{
	@Override
	public Usuario mapRow(ResultSet row, int rowNum) throws SQLException {
		Usuario u=new Usuario();
		u.setLogin(row.getString("login"));
		u.setPassword(row.getString("password"));
		u.setEstado(row.getInt("estado"));
		u.setIdper(row.getInt("idper"));
		return u;
	}
}
