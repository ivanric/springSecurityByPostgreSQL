package app.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.IRolDAO;
import app.dao.IUsuarioDAO;
import app.entity.Rol;
import app.entity.Usuario;

@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	IUsuarioDAO iUsuarioDAO;
	@Autowired
	IRolDAO iRolDAO;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //UserDetails interfaz de spring
		Usuario user;
		String usuario,contraseña;
		List<Rol> ListaRoles;
		try {
			user=this.iUsuarioDAO.getUserByUsername(username);
			//Clase Optional 
			//Optional<Usuario> usuarioOptional=Optional.of(user);//Se crea un usuario de tipo optional es decir q si es nul optionalUser recibe el valor vacio  caso contrario se almacena el Usuario
			usuario=user.getLogin();
			contraseña=user.getPassword();
			ListaRoles=this.iRolDAO.AllRoleByUsername(user.getLogin());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		//return usuarioOptional.map(AQUI RECIBE UNA CLASE).get();
		return this.userBuild(usuario, contraseña, ListaRoles);
	
	}
	
	private User userBuild(String username,String password,List<Rol> roles) {//User implementacion de UserDeatils
		boolean enabled=true;
		boolean accountNonExpired=true;
		boolean credentialsNonExpired=true;
		boolean accountNonLocked=true;
		List<GrantedAuthority> authorities=new ArrayList<>();
		for (Rol rol : roles) {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+rol.getNombre()));
		}
		return new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

}
