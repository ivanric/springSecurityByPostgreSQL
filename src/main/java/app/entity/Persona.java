package app.entity;

import java.util.List;

public class Persona {
	private int idper;
	private int ci;
	private String nombre,ap,am,direccion;
	private List<Profesion> profesiones;
	public int getIdper() {
		return idper;
	}
	public void setIdper(int idper) {
		this.idper = idper;
	}
	public int getCi() {
		return ci;
	}
	public void setCi(int ci) {
		this.ci = ci;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAp() {
		return ap;
	}
	public void setAp(String ap) {
		this.ap = ap;
	}
	public String getAm() {
		return am;
	}
	public void setAm(String am) {
		this.am = am;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<Profesion> getProfesiones() {
		return profesiones;
	}
	public void setProfesiones(List<Profesion> profesiones) {
		this.profesiones = profesiones;
	}
	@Override
	public String toString() {
		return "Persona [idper=" + idper + ", ci=" + ci + ", nombre=" + nombre + ", ap=" + ap + ", am=" + am
				+ ", direccion=" + direccion + ", profesiones=" + profesiones + "]";
	}
	
}
