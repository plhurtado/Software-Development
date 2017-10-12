/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package ControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControlVelocidadTest {

	@Test
	public void testConstructor() {
		ControlVelocidad cv = new ControlVelocidad();
		assertNotNull(cv);
		assertNotNull(cv.acelera);
		assertNotNull(cv.almacena);
		assertNotNull(cv.getAutomatico());
		assertNotNull(cv.eje);
		assertNotNull(cv.freno);
		assertNotNull(cv.motor);
		assertNotNull(cv.estadoPalanca);
		assertNotNull(cv.getReloj());
		assertEquals(cv.getTiempo(), 0);
	}
	@Test
	public void testStart(){
		ControlVelocidad cv = new ControlVelocidad();
		cv.start();
		assertTrue(cv.getReloj().isAlive());
	}
	@Test
	public void testControlarEstado(){
		ControlVelocidad cv = new ControlVelocidad();
		
		// motor encendido, palanca apagada, acelerando
		cv.motor.cambiarEstado();
		cv.cambiarPalanca(Palanca.APAGADO);
		cv.acelera.pisarPedal();
		cv.controlarEstado();
		assertTrue(cv.encendido_apagada_acelerando);
		
		//motor encendido, palanca apagada, acelerando
		cv = new ControlVelocidad();
		cv.motor.cambiarEstado();
		cv.cambiarPalanca(Palanca.APAGADO);
		cv.freno.pisarPedal();
		cv.controlarEstado();
		assertTrue(cv.encendido_apagada_frenando);
		
		//motor encendido, palanca apagada, rozamiento
		cv = new ControlVelocidad();
		cv.motor.cambiarEstado();
		cv.cambiarPalanca(Palanca.APAGADO);
		cv.controlarEstado();
		assertTrue(cv.encendido_apagada_rozamiento);
		
		//motor encendido, palanca mantenida
		cv = new ControlVelocidad();
		cv.motor.cambiarEstado();
		cv.cambiarPalanca(Palanca.MANTENIENDO);
		cv.controlarEstado();
		assertTrue(cv.encendido_manteniendo);
		
		//motor encendido, palanca reiniciando
		cv = new ControlVelocidad();
		cv.motor.cambiarEstado();
		cv.cambiarPalanca(Palanca.REINICIANDO);
		cv.controlarEstado();
		assertTrue(cv.encendido_reiniciando);
		
		//motor apagado y frenando
		cv = new ControlVelocidad();
		cv.freno.pisarPedal();
		cv.controlarEstado();
		assertTrue(cv.apagado_frenando);
		
		//motor apagado
		cv = new ControlVelocidad();
		cv.controlarEstado();
		assertTrue(cv.apagado);
	}
	@Test
	public void testCambiarPalanca(){
		ControlVelocidad cv = new ControlVelocidad();
		assertEquals(cv.estadoPalanca.leerEstado(), 0);
		cv.cambiarPalanca(1);
		assertEquals(cv.estadoPalanca.leerEstado(), 1);
	}
	@Test
	public void testObtenerVel(){
		ControlVelocidad cv = new ControlVelocidad();
		assertEquals(cv.obtenerVel(), cv.almacena.leerVelocidad());
	}
	
	// ... Resto de métodos son triviales como el anterior
	
	@Test
	public void testEquals(){
		ControlVelocidad c1 = new ControlVelocidad();
		assertNotNull(c1);
		ControlVelocidad c2 = new ControlVelocidad();
		assertNotNull(c2);
		ControlVelocidad c3 = new ControlVelocidad();
		assertNotNull(c3);

		
		// Transitiva
		assertEquals(c1,c2);
		assertEquals(c2,c3);
		assertEquals(c1,c3);
		
		// Reflexiva
		assertEquals(c1,c1);
		assertEquals(c2,c2);
		assertEquals(c3,c3);
		
		// Simétrica
		assertEquals(c1,c2);
		assertEquals(c2,c1);
		assertEquals(c2,c3);
		assertEquals(c3,c2);
		assertEquals(c1,c3);
		assertEquals(c3,c1);
	}

}
