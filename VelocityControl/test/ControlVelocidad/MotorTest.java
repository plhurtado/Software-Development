/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package ControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Test;

public class MotorTest {

	@Test
	public void testConstructor() {
		Motor m = new Motor();
		assertNotNull(m);
		assertFalse(m.leerEstado());
	}
	@Test
	public void testCambiarEstado(){
		Motor m = new Motor();
		m.cambiarEstado();
		assertTrue(m.leerEstado());
		m.cambiarEstado();
		assertFalse(m.leerEstado());
	}
	@Test
	public void testEquals(){
		Motor m1 = new Motor();
		assertNotNull(m1);
		Motor m2 = new Motor();
		assertNotNull(m2);
		Motor m3 = new Motor();
		assertNotNull(m3);

		
		// Transitiva
		assertEquals(m1,m2);
		assertEquals(m2,m3);
		assertEquals(m1,m3);
		
		// Reflexiva
		assertEquals(m1,m1);
		assertEquals(m2,m2);
		assertEquals(m3,m3);
		
		// Simétrica
		assertEquals(m1,m2);
		assertEquals(m2,m1);
		assertEquals(m2,m3);
		assertEquals(m3,m2);
		assertEquals(m1,m3);
		assertEquals(m3,m1);
	}
}
