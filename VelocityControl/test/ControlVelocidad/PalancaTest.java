/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package ControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalancaTest {

	@Test
	public void testConstructor() {
		Palanca p = new Palanca();
		assertNotNull(p);
		int valor_esperado = 0;
		int valor_obtenido = p.leerEstado();
		
		assertEquals(valor_esperado, valor_obtenido);
	}
	@Test
	public void testCambiarEstado(){
		Palanca p = new Palanca();
		p.cambiarEstado(1);
		int valor_esperado = 1;
		int valor_obtenido = p.leerEstado();
		
		assertEquals(valor_esperado, valor_obtenido);
	}
	@Test
	public void testEquals(){
		Palanca p1 = new Palanca();
		assertNotNull(p1);
		Palanca p2 = new Palanca();
		assertNotNull(p2);
		Palanca p3 = new Palanca();
		assertNotNull(p3);
		
		// Transitiva
		assertEquals(p1,p2);
		assertEquals(p2,p3);
		assertEquals(p1,p3);
		
		// Reflexiva
		assertEquals(p1,p1);
		assertEquals(p2,p2);
		assertEquals(p3,p3);
		
		// Simétrica
		assertEquals(p1,p2);
		assertEquals(p2,p1);
		assertEquals(p2,p3);
		assertEquals(p3,p2);
		assertEquals(p1,p3);
		assertEquals(p3,p1);
	}

}
