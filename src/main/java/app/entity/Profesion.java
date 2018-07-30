package app.entity;

public class Profesion {
	private int idper,estado;
	private String profesion;
	public int getIdper() {
		return idper;
	}
	public void setIdper(int idper) {
		this.idper = idper;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	@Override
	public String toString() {
		return "Profesion [idper=" + idper + ", estado=" + estado + ", profesion=" + profesion + "]";
	}
	
}
