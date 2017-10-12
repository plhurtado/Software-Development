/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package Monitorizacion;

import Simulador.Interfaz;
import Simulador.PanelBotones;
import ControlVelocidad.ControlVelocidad;
import ControlVelocidad.Eje;
import static org.junit.Assert.*;
import org.junit.Test;


public class ReseteoTest{

	PanelBotones panelBotones;
	ControlVelocidad c;
	CalculadorVelMed vel;
	Reseteo res;
	Deposito depo;
	Interfaz interfaz;
	Eje eje;
	Monitorizacion monitor;
	
	@Test
	public void testConstructor(){
		res = new Reseteo();
		assertNotNull(res);
		assertTrue(res instanceof Reseteo);
	}
	
	@Test
	public void testComprobarNotificaciones() {
		interfaz = new Interfaz();
		panelBotones = new PanelBotones(interfaz);
		eje = new Eje();
		monitor = new Monitorizacion(eje);
		c = new ControlVelocidad();
		vel = new CalculadorVelMed();
		depo= new Deposito();
		res = new Reseteo();
		
		panelBotones.aniadirComponentes(monitor, c);
		assertNotNull(panelBotones.getControl().getAlmacen());
		panelBotones.getControl().getEje().incrementarVueltas(400);
		panelBotones.getControl().getEje().calcularVelocidad(panelBotones.getControl().getAlmacen());
		assertTrue(panelBotones.getControl().getEje().leerRevolucionesTotales()>0);
		
		vel.calcularGastoMedio(panelBotones.getControl().getEje(), depo);
		
		res.inicializarValores(vel, panelBotones.getControl().getEje());
		assertTrue(panelBotones.getControl().getEje().leerRevolucionesTotales()==0);
	}
}
