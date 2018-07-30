package app.dao;

import java.util.List;

import app.entity.Rol;

public interface IRolDAO {
	List<Rol> AllRoleByUsername(String username);
}	
