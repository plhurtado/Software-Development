/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package ControlVelocidad;

import static org.junit.Assert.*;
import org.junit.Test;

public class AutomaticoTest {

	@Test
	public void test() {
		Automatico auto = new Automatico();
		assertNotNull(auto);
	}
	
	@Test
	public void testMantenerVelocidad(){
		Automatico auto = new Automatico();
		Acelerador acelerador = new Acelerador();
		Freno freno = new Freno();
		Almacenamiento alm = new Almacenamiento();
		Eje eje = new Eje();
		
		alm.almacenarVelocidad(1000);
		alm.almacenarVelSeleccionada();
		
		// velocidad > velocidad_seleccionada
		alm.almacenarVelocidad(1300);
		eje.incrementarVueltas(300);
		auto.mantenerVelocidad(acelerador, freno, alm, eje);
		int esperado = 0;
		int obtenido = eje.leerRevoluciones();
		assertEquals(esperado, obtenido);
		
		// velocidad < velocidad_seleccionada
		alm.almacenarVelocidad(700);
		auto.mantenerVelocidad(acelerador, freno, alm, eje);
		esperado = 300;
		obtenido = eje.leerRevoluciones();
		assertEquals(esperado, obtenido);
		
		// velocidad < velocidad_seleccionada
		alm.almacenarVelocidad(1000);
		auto.mantenerVelocidad(acelerador, freno, alm, eje);
		esperado = 300;
		obtenido = eje.leerRevoluciones();
		assertEquals(esperado, obtenido);
	}
	@Test
	public void testEquals(){
		Automatico a1 = new Automatico();
		assertNotNull(a1);
		Automatico a2 = new Automatico();
		assertNotNull(a2);
		Automatico a3 = new Automatico();
		assertNotNull(a3);
		
		// Transitiva
		assertEquals(a1,a2);
		assertEquals(a2,a3);
		assertEquals(a1,a3);
		
		// Reflexiva
		assertEquals(a1,a1);
		assertEquals(a2,a2);
		assertEquals(a3,a3);
		
		// Simétrica
		assertEquals(a1,a2);
		assertEquals(a2,a1);
		assertEquals(a2,a3);
		assertEquals(a3,a2);
		assertEquals(a1,a3);
		assertEquals(a3,a1);
	}

}
