/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package Simulador;

import static org.junit.Assert.*;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ListaObservadoresObservablesTest {
	Interfaz interfaz;
	Simulacion simulacion;
	ObservadorTestListener observador_t_s;
	List<Observador> lista_observadores;
	
	@Before
	public void testInit(){
		this.interfaz = new Interfaz();		
		this.simulacion = this.interfaz.getSimulacion();
		this.lista_observadores = this.simulacion.getObservadores();
		this.observador_t_s = new ObservadorTestListener(this.interfaz);
	}
	@Test
	public void testConstructor(){
		assertNotNull(lista_observadores);
		assertNotNull(interfaz);
		assertNotNull(simulacion);
		assertNotNull(observador_t_s);
	}
	
	@Test
	public void testAniadirObservador(){
		assertEquals(lista_observadores.size(),2); // PanelBotones y PanelEtiquetas
		for (Object o : lista_observadores){
			assertTrue(o instanceof Observador);
		}
		simulacion.aniadirObservador(observador_t_s);
		assertEquals(3,lista_observadores.size());
	}
	@Test
	public void testEliminarObservador(){
		simulacion.aniadirObservador(observador_t_s);
		assertEquals(3,lista_observadores.size());
		simulacion.eliminarObservador(observador_t_s);
		assertEquals(2,lista_observadores.size());
	}
	@Test
	public void testNotificarObservadores(){
		List<Object> eventos = new ArrayList<Object>();
		simulacion.aniadirObservador(observador_t_s);
		
		MouseEvent mouse_event = new MouseEvent(new Label(), 0, 0, 0, 0, 0, 0, false);
		ActionEvent action_event = new ActionEvent(mouse_event.getSource(), mouse_event.getID(), mouse_event.paramString());
		
		// encendiendo
		simulacion.getPanelBotones().BotonEncenderActionPerformed(action_event);
		eventos.add("Parado2");
		
		// acelerando
		simulacion.getPanelBotones().pulsarAcelerador();
		simulacion.getPanelBotones().BotonAcelerarActionPerformed(action_event);
		eventos.add("Acelerando");
		
		// manteniendo velocidad
		simulacion.getPanelBotones().BotonMantenerActionPerformed(action_event);
		eventos.add("Manteniendo");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// frenando
		simulacion.getPanelBotones().pulsarFreno();
		simulacion.getPanelBotones().BotonFrenoActionPerformed(action_event);
		eventos.add("Frenando");
		
		// apagamos
		simulacion.getPanelBotones().BotonEncenderActionPerformed(action_event);
		eventos.add("Parado2");
		
		// Deben coincidir los eventos 
		PanelBotones panel = simulacion.getPanelBotones();
		assertEquals(eventos,simulacion.getEventosProducidos().get(panel));
	}

}
