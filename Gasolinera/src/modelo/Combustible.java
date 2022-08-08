package modelo;

import java.util.Objects;

public class Combustible {
	
	private String nombre;
	private double precio;

	public Combustible() {
		this.nombre="";
		this.precio=0;
	}

	public Combustible(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return nombre + " - " + precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combustible other = (Combustible) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	

}
