/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package ControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Test;

public class PedalTest {

	@Test
	public void testConstructor() {
		Pedal p = new Freno();
		assertNotNull(p);
		assertFalse(p.leerEstado());
		
		p = new Acelerador();
		assertNotNull(p);
		assertFalse(p.leerEstado());
	}
	@Test
	public void testActualizar(){
		Pedal p = new Acelerador();
		Eje eje = new Eje();
		p.actualizar(100, eje);
		int esperado = 100;
		int obtenido = eje.leerRevoluciones();
		
		assertEquals(esperado, obtenido);
		
		p = new Freno();
		p.actualizar(100, eje);
		esperado = 0;
		obtenido = eje.leerRevoluciones();
		
		assertEquals(esperado, obtenido);
	}
	@Test
	public void testActualizarPedal(){
		Pedal p = new Acelerador();
		double esperado = 225;
		double obtenido = p.actualizarPedal(50);
		
		assertEquals(esperado, obtenido,0);
		
		p = new Freno();
		esperado = 800;
		obtenido = p.actualizarPedal(0);
		
		assertEquals(esperado, obtenido,0);
	}
	@Test
	public void testSoltarPedal(){
		Pedal p = new Acelerador();
		p.soltarPedal();
		assertFalse(p.leerEstado());
		
		p = new Freno();
		p.soltarPedal();
		assertFalse(p.leerEstado());
	}
	@Test
	public void testPisarPedal(){
		Pedal p = new Acelerador();
		p.pisarPedal();
		assertTrue(p.leerEstado());
		
		p = new Freno();
		p.pisarPedal();
		assertTrue(p.leerEstado());
	}
	@Test
	public void testEqualsObject() {
		Pedal p = new Acelerador();
		assertNotNull(p);
		Pedal p2 = new Acelerador();
		assertNotNull(p2);
		Pedal p3 = new Acelerador();
		assertNotNull(p3);
		
		//Reflexión
		assertEquals(p,p); 
		assertEquals(p2,p2); 
		assertEquals(p3,p3); 
	
		//Transitividad
		assertEquals(p,p2);
		assertEquals(p2,p3);
		assertEquals(p,p3);
	
		//Simetría
		assertEquals(p,p2);
		assertEquals(p2,p);
		assertEquals(p,p3);
		assertEquals(p3,p);
		assertEquals(p2,p3);
		assertEquals(p3,p2);
		
		/////// FRENO
		p = new Freno();
		assertNotNull(p);
		p2 = new Freno();
		assertNotNull(p2);
		p3 = new Freno();
		assertNotNull(p3);
		
		//Reflexión
		assertEquals(p,p); 
		assertEquals(p2,p2); 
		assertEquals(p3,p3); 
	
		//Transitividad
		assertEquals(p,p2);
		assertEquals(p2,p3);
		assertEquals(p,p3);
	
		//Simetría
		assertEquals(p,p2);
		assertEquals(p2,p);
		assertEquals(p,p3);
		assertEquals(p3,p);
		assertEquals(p2,p3);
		assertEquals(p3,p2);
	}

}
