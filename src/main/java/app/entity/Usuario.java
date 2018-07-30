package app.entity;

public class Usuario {
	private String login;
	private String password;
	private int estado;
	private int idper;
	

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getIdper() {
		return idper;
	}
	public void setIdper(int idper) {
		this.idper = idper;
	}
	
}
