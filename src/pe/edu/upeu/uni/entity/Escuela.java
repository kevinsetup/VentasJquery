package pe.edu.upeu.uni.entity;

public class Escuela {
	private int idescuela;
	private String nombrecat;
	public Escuela(int idescuela, String nombrecat) {
		super();
		this.idescuela = idescuela;
		this.nombrecat = nombrecat;
	}
	public Escuela() {
		super();
	}
	public int getIdescuela() {
		return idescuela;
	}
	public void setIdescuela(int idescuela) {
		this.idescuela = idescuela;
	}
	public String getNombrecat() {
		return nombrecat;
	}
	public void setNombrecat(String nombrecat) {
		this.nombrecat = nombrecat;
	}
	
	
	
	
}
