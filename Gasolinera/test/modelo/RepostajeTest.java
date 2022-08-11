package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RepostajeTest {

	@Test
	void getPrecioLitroDescuentoTest() {
		
		Repostaje r = new Repostaje("","","",
				         new Combustible("Gasolina", 1.794),
				         30, false,false,false);
		assertEquals(1.794, r.getPrecioLitroDescuento());
		r.setAgrario(true);
		assertEquals(1.794-0.45, r.getPrecioLitroDescuento());
		r.setGobierno(true);
		assertEquals(1.794-0.45, r.getPrecioLitroDescuento());
		r.setVuelves(true);
		assertEquals(1.794-0.45, r.getPrecioLitroDescuento());
		r.setAgrario(false);
		assertEquals(1.794-0.2-0.05, r.getPrecioLitroDescuento());
		r.setVuelves(false);
		assertEquals(1.794-0.2, r.getPrecioLitroDescuento());
		r.setVuelves(true);
		r.setGobierno(false);
		assertEquals(1.794-0.05, r.getPrecioLitroDescuento());
	}
	
	@Test
	void setTotalTest() {
		Repostaje r = new Repostaje("","","",
		         new Combustible("Gasolina", 1.794),
		         30, true,false,false);
		r.setTotal(50);
		assertAll (
				() -> assertEquals(50,r.getTotal(),
						"El importe total debe seguir siendo 50"),
				() -> assertEquals(50/r.getPrecioLitroDescuento(), 
						 r.getLitros(),
						 "El número de litros no coreponde a 50 € con descuento"
						 )
		);
		
	}

}
