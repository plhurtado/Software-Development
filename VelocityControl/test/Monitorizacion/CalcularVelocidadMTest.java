/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package Monitorizacion;

import static org.junit.Assert.*;
import org.junit.Test;
import Simulador.Interfaz;
import Simulador.PanelBotones;
import ControlVelocidad.ControlVelocidad;
import ControlVelocidad.Eje;

public class CalcularVelocidadMTest{
	
	CalculadorVelMed calculos;
	PanelBotones panelBotones;
	ControlVelocidad c;
	Deposito deposito;
	Interfaz interfaz;
	Monitorizacion monitor;
	Eje eje;
	

	@Test
	public void testConstructor(){
		interfaz = new Interfaz();
		assertNotNull(interfaz);
		assertTrue(interfaz instanceof Interfaz);
		panelBotones = new PanelBotones(interfaz);
		assertNotNull(panelBotones);
		assertTrue(panelBotones instanceof PanelBotones);
		eje = new Eje();
		assertNotNull(eje);
		assertTrue(eje instanceof Eje);
		monitor = new Monitorizacion(eje);
		assertNotNull(monitor);
		assertTrue(monitor instanceof Monitorizacion);
		c = new ControlVelocidad();
		assertNotNull(c);
		assertTrue(c instanceof ControlVelocidad);
		deposito = new Deposito();
		assertNotNull(deposito);
		assertTrue(deposito instanceof Deposito);
		calculos = new CalculadorVelMed();
		assertNotNull(calculos);
		assertTrue(calculos instanceof CalculadorVelMed);
	}

	/*
	 * Test para comprobar el calculo de velocidad media y actualizacion del deposito.
	 */

	@Test
	public void testCalculadorVelocidadMedia() {
		deposito = new Deposito();
		interfaz = new Interfaz();
		panelBotones = new PanelBotones(interfaz);
		calculos = new CalculadorVelMed();
		c = new ControlVelocidad();
		eje = new Eje();
		monitor = new Monitorizacion(eje);
		
		double nivelDepositoInicial = deposito.leerNivelActual();
		
		panelBotones.aniadirComponentes(monitor, c);;
		assertNotNull(panelBotones.getControl().getAlmacen());
		panelBotones.getControl().getEje().incrementarVueltas(eje.MAXVUELTAS);
		panelBotones.getControl().getEje().calcularVelocidad(panelBotones.getControl().getAlmacen());
		
		calculos.calcularVelocidadMedia(panelBotones.getControl().getEje());

		assertTrue(calculos.leerVelMedia()>0);
		assertTrue(deposito.leerNivelActual() ==  nivelDepositoInicial);
	}

}
