/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package Monitorizacion;

import ControlVelocidad.Eje;
import static org.junit.Assert.*;
import org.junit.Test;


public class MonitorizacionTest{

	private Monitorizacion monitor;
	private Eje eje;
	
	@Test
	public void testConstructor(){
		eje = new Eje();
		assertNotNull(eje);
		assertTrue(eje instanceof Eje);
		monitor = new Monitorizacion(eje);
		assertNotNull(monitor);
		assertTrue(monitor instanceof Monitorizacion);
	}
}
