package app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.entity.Profesion;
import app.entity.ProfesionRowMapper;
@Transactional
@Repository
public class ProfesionDAO implements IProfesionDAO{
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Profesion> getAllProfesiones(int id) {
		String sql = "SELECT pr.* FROM persona p,profesion pr where pr.idper=p.idper and p.idper=?";
		RowMapper<Profesion> rowMapper = new ProfesionRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper,id);
	}
}
