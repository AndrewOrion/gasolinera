package controladores;

import java.util.ArrayList;
import java.util.List;

import modelo.Combustible;
import vistas.FormularioAlta;

public class Principal {
	
	private FormularioAlta fAlta;
	private List<Combustible> listaCombustibles;

	public Principal() {
		fAlta = new FormularioAlta();
		listaCombustibles = new ArrayList<Combustible> ();
		listaCombustibles.add(new Combustible("Gasolina",1.794));
		listaCombustibles.add(new Combustible("Gasoil",1.773));
		listaCombustibles.add(new Combustible("Gasolina Plus",1.832));
		listaCombustibles.add(new Combustible("Gasoil Plus",1.842)); 
		fAlta.setListaCombustibles(listaCombustibles);
		fAlta.setVisible(true);
		
	}

	public static void main(String[] args) {
		Principal ppal = new Principal();
	}

}
