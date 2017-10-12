/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package ControlVelocidad;

import static org.junit.Assert.*;
import org.junit.Test;

public class EjeTest {

	@Test
	public void test() {
		Eje eje = new Eje();
		assertNotNull(eje);
		
		int vueltas = eje.leerRevoluciones();
		assertNotNull(vueltas);
		
		int esperado = 0;
		assertEquals(esperado,vueltas);
		
		long vueltasTotales = eje.leerRevolucionesTotales();
		assertNotNull(vueltasTotales);
		
		long esperado2 = 0;
		assertEquals(esperado2,vueltasTotales);
		
		assertNotNull(eje.getCalculador());
	}
	
	@Test
	public void testIncrementarVueltas(){
		Eje eje = new Eje();
		int incremento = 500;
		
		eje.incrementarVueltas(incremento);
		
		int esperado = incremento;
		int obtenido = eje.leerRevoluciones();
		
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void testResetear(){
		Eje eje = new Eje();
		eje.resetear();
		
		long esperado = 0;
		long obtenido = eje.leerRevolucionesTotales();
		
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void testCalcularVelocidad(){
		Almacenamiento alm = new Almacenamiento();
		Eje eje = new Eje();
		
		eje.incrementarVueltas(100);
		eje.calcularVelocidad(alm);
		
		long vueltas_totales_esperado = 100/24;
		long vueltas_totales_obtenido = eje.leerRevolucionesTotales();
		
		assertEquals(vueltas_totales_esperado, vueltas_totales_obtenido);
		int velocidadAnterior = eje.getVelocidadAnterior();
		assertNotNull(velocidadAnterior);
	}
	
	@Test
	public void testEquals(){
		Eje eje_a = new Eje();
		assertNotNull(eje_a);
		Eje eje_b = new Eje();
		assertNotNull(eje_b);
		Eje eje_c = new Eje();
		assertNotNull(eje_c);
		
		// Transitiva
		assertEquals(eje_a,eje_b);
		assertEquals(eje_b,eje_c);
		assertEquals(eje_a,eje_c);
		
		// Reflexiva
		assertEquals(eje_a,eje_a);
		assertEquals(eje_b,eje_b);
		assertEquals(eje_c,eje_c);
		
		// Simétrica
		assertEquals(eje_a,eje_b);
		assertEquals(eje_b,eje_a);
		assertEquals(eje_a,eje_c);
		assertEquals(eje_c,eje_a);
		assertEquals(eje_b,eje_c);
		assertEquals(eje_c,eje_b);
	}

}
