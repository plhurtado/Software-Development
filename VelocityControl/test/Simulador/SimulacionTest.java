/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package Simulador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SimulacionTest {
	Interfaz interfaz;
	Simulacion simulacion;
	
	@Before
	public void testInit(){
		interfaz = new Interfaz();
		simulacion = interfaz.getSimulacion();
	}
	
	@Test
	public void testConstructor() {
		assertNotNull(interfaz);
		assertNotNull(simulacion);
		assertTrue(interfaz instanceof Interfaz);
		assertTrue(simulacion instanceof Simulacion);
	}
	@Test
	public void testPanel(){
		assertTrue(simulacion.getPanelBotones() instanceof PanelBotones);
		assertTrue(simulacion.getPanelEtiquetas() instanceof PanelEtiquetas);
	}
	@Test
	public void testTerminarSimulacion(){
		simulacion.terminarSimulacion();
		assertFalse(simulacion.funcionando);
	}
	

}
