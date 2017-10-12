/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package ControlVelocidad;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculadorVelTest {

	@Test
	public void testConstructor() {
		CalculadorVel cv = new CalculadorVel();
		assertNotNull(cv);
	}
	@Test
	public void testAlmacenarVelocidad(){
		CalculadorVel cv = new CalculadorVel();
		Almacenamiento alm = new Almacenamiento();
		assertNotNull(alm);
		cv.almacenarVelocidad(100, alm);
		assertTrue(alm.almacenar_called);
	}
	@Test
	public void testCalcularVelocidad(){
		CalculadorVel cv = new CalculadorVel();
		Almacenamiento alm = new Almacenamiento();
		double esperado = (100*5)/40;
		cv.calcularVelocidad(100, 5, alm);
		double obtenido = alm.leerVelocidad();
		
		assertEquals(esperado,obtenido,0);
	}
}
