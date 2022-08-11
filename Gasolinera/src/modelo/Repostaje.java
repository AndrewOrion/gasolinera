package modelo;

import java.util.Objects;

public class Repostaje {

	private String matricula;
	private String nombre;
	private String dni;
	private Combustible combustible;
	private double litros;
	private boolean agrario;
	private boolean gobierno;
	private boolean vuelves;
	
	public static final double DESCUENTO_AGRARIO=0.45;
	public static final double DESCUENTO_GOBIERNO=0.2;
	public static final double DESCUENTO_VUELVES=0.05;
	
	public Repostaje() {
		this.matricula="";
		this.nombre="";
		this.dni="";
		this.combustible= new Combustible();
		this.litros=0;
		this.agrario=this.gobierno= this.vuelves=false;
	}
	
	

	public Repostaje(String matricula, String nombre, String dni, Combustible combustible, double litros,
			boolean agrario, boolean gobierno, boolean vuelves) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.dni = dni;
		this.combustible = combustible;
		this.litros = litros;
		this.agrario = agrario;
		this.gobierno = gobierno;
		this.vuelves = vuelves;
	}



	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Combustible getCombustible() {
		return combustible;
	}

	public void setCombustible(Combustible combustible) {
		this.combustible = combustible;
	}

	public double getLitros() {
		return litros;
	}

	public void setLitros(double litros) {
		this.litros = litros;
	}

	public boolean isAgrario() {
		return agrario;
	}

	public void setAgrario(boolean agrario) {
		this.agrario = agrario;
	}

	public boolean isGobierno() {
		return gobierno;
	}

	public void setGobierno(boolean gobierno) {
		this.gobierno = gobierno;
	}

	public boolean isVuelves() {
		return vuelves;
	}

	public void setVuelves(boolean vuelves) {
		this.vuelves = vuelves;
	}
	
	protected double getPrecioLitroDescuento() {
		double precio = this.combustible.getPrecio();
		if (isAgrario()) {
			precio = precio - DESCUENTO_AGRARIO;
		} else {
			if (isGobierno()) {
				precio=precio-DESCUENTO_GOBIERNO;
			}
			if (isVuelves()) {
				precio = precio - DESCUENTO_VUELVES;
			}
		}
		return precio;
	}
	
	public double getTotal() {
		return getPrecioLitroDescuento()*this.litros;
	}
	
	public void setTotal(double total) {
		double precio = getPrecioLitroDescuento();
		this.litros=total/precio;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Repostaje other = (Repostaje) obj;
		return Objects.equals(matricula, other.matricula);
	}
	

}
