/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package Simulador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InterfazTest {
	private Interfaz interfaz;

	@Before
	public void testInit(){
		interfaz = new Interfaz();
	}
	@Test
	public void testConstructor() {
		assertNotNull(interfaz);
		assertTrue(interfaz instanceof Interfaz);
	}
	@Test
	public void test(){
		assertNotNull(interfaz.simulacion);
		assertNotNull(interfaz.monitor);
		assertNotNull(interfaz.etiquetaVelAuto);
		assertNotNull(interfaz.etiquetaEstado);
		assertNotNull(interfaz.control);
	}
	

}
