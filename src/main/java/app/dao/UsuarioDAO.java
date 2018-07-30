package app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.entity.Usuario;
@Transactional
@Repository
public class UsuarioDAO  implements IUsuarioDAO{
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	@Override
	public Usuario getUserByUsername(String nombreUsuario) {
		String sql = "SELECT * FROM usuario WHERE login= ?";
		RowMapper<Usuario> rowMapper = new BeanPropertyRowMapper<Usuario>(Usuario.class);
		Usuario Usuario = jdbcTemplate.queryForObject(sql, rowMapper, nombreUsuario);
		return Usuario;
	}

}
