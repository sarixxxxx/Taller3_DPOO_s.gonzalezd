package uniandes.dpoo.aerolinea.modelo;

public class Avion {
	public String nombre;
	public int capacidad;
	public Avion(String nombre, int capacidad) {
		super();
		this.nombre = nombre;
		this.capacidad = capacidad;
	}
	public String getNombre() {
		return nombre;
	}
	public int getCapacidad() {
		return capacidad;
	}
	
}
