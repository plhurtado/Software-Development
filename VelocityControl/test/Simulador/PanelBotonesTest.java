/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package Simulador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PanelBotonesTest {
	Interfaz interfaz;
	PanelBotones p_botones;
	PanelEtiquetas p_etiquetas;
	
	@Before
	public void testInit(){
		interfaz = new Interfaz();
		p_botones = interfaz.getSimulacion().getPanelBotones();
		p_etiquetas = interfaz.getSimulacion().getPanelEtiquetas();
	}
	@Test
	public void testConstructor() {
		assertNotNull(interfaz);
		assertTrue(interfaz instanceof Interfaz);
		assertNotNull(p_botones);
		assertNotNull(p_etiquetas);
		assertTrue(p_botones instanceof PanelBotones);
		assertTrue(p_etiquetas instanceof PanelEtiquetas);
	}
}
