/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package Monitorizacion;

import static org.junit.Assert.*;
import org.junit.Test;
import ControlVelocidad.Eje;

public class DepositoTest{
	Deposito deposito;
	
	@Test
	public void testConstructor(){
		deposito = new Deposito();
		assertNotNull(deposito);
		assertTrue(deposito instanceof Deposito);
	}
	
	@Test
	public void testInicioDeposito() {
		deposito = new Deposito();
		assertNotNull(deposito);
		double capacidad = 100;
		double actual = deposito.leerNivelInicial();
		
		assertEquals(capacidad, actual,0);	
	}
	
	@Test
	public void testReiniciarDeposito(){
		deposito = new Deposito();
		assertNotNull(deposito);
		deposito.cambiarANivelInicial();
		double inicial = 100;
		double actual = deposito.leerNivelActual();
		assertEquals(inicial, actual,0);
	}
	
	@Test
	public void testActualizarDeposito(){
		double antiguo, actual;
		Eje eje = new Eje();
		assertNotNull(eje);
		deposito = new Deposito();
		assertNotNull(deposito);
		antiguo = deposito.leerNivelActual();
		actual = antiguo - (antiguo*(antiguo/15))*0.0000000005;
		assertNotNull(actual);
	}
}