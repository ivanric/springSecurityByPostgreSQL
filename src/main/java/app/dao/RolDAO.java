package app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.entity.Rol;
import app.entity.RolRowMapper;
@Transactional
@Repository
public class RolDAO  implements IRolDAO{
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Rol> AllRoleByUsername(String username) {
		String sql = "SELECT r.* FROM rol r,usuario u,rolusu ru WHERE r.idrol=ru.idrol AND u.login=ru.login AND u.login=?";
		RowMapper<Rol> rowMapper = new RolRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper,username);
	}

}
