/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package ControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Test;

public class RelojTest {

	@Test
	public void testConstructor() {
		Reloj reloj = new Reloj(new ControlVelocidad());
		assertNotNull(reloj);
		assertNotNull(reloj.getControlVelocidad());
	}
	
	@Test
	public void testRun() {
		ControlVelocidad control = new ControlVelocidad();
		Reloj reloj = new Reloj(control);
		reloj.start();
		
		// comprobamos que la hebra está funcionando
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

	@Test
	public void testEquals() {
		ControlVelocidad control = new ControlVelocidad();
		Reloj r1 = new Reloj(control);
		assertNotNull(r1);
		Reloj r2 = new Reloj(control);
		assertNotNull(r2); 
		Reloj r3 = new Reloj(control);
		assertNotNull(r3);
		
		//Reflexión
		assertEquals(r1,r1); 
		assertEquals(r2,r2); 
		assertEquals(r3,r3); 
	
		//Transitividad
		assertEquals(r1,r2);
		assertEquals(r2,r3);
		assertEquals(r1,r3);
	
		//Simetría
		assertEquals(r1,r2);
		assertEquals(r2,r1);
		assertEquals(r1,r3);
		assertEquals(r3,r1);
		assertEquals(r2,r3);
		assertEquals(r3,r2);
	}

}
