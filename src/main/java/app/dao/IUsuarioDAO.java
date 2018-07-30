package app.dao;
import app.entity.Usuario;

public interface IUsuarioDAO {
	Usuario getUserByUsername(String nombreUsuario);
}
