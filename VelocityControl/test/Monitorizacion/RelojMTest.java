/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package Monitorizacion;


import static org.junit.Assert.*;
import org.junit.Test;

import ControlVelocidad.ControlVelocidad;
import ControlVelocidad.Eje;
import ControlVelocidad.Reloj;

public class RelojMTest {

	@Test
	public void testConstructor(){
		RelojM reloj = new RelojM(new Monitorizacion(new Eje()));
		assertNotNull(reloj);
	}
	
	@Test
	public void testRun() {
		ControlVelocidad control = new ControlVelocidad();
		Reloj reloj = new Reloj(control);
		reloj.start();
		
		// Comprobamos que la hebra está funcionando
		assertTrue(reloj.isAlive());
		
		try {
		    Thread.sleep(reloj.getIntervalo()+5);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		int valor_esperado = reloj.getIntervalo();
		int valor_obtenido = control.getTiempo();
		
		assertEquals(valor_esperado, valor_obtenido);
	}
}
