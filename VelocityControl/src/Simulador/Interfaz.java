/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package Simulador;
import javax.swing.*;
import ControlVelocidad.*;
import Monitorizacion.*;

@SuppressWarnings("serial")
public class Interfaz extends JApplet {
	JLabel etiquetaVelAuto, etiquetaEstado;
	Simulacion simulacion;
	Monitorizacion monitor;
	ControlVelocidad control;
	public void init(){
		this.setSize(800,600);
	}
	public Interfaz(){
		PanelEtiquetas panelE = new PanelEtiquetas(this);
		PanelBotones panelB = new PanelBotones(this);
		this.simulacion = new Simulacion(panelE,panelB);
		control = new ControlVelocidad();
		monitor = new Monitorizacion(control.eje);		
		panelE.aniadirComponentes(monitor, control);
		panelB.aniadirComponentes(monitor, control);
		
		Thread t_simulacion = new Thread(simulacion);
		t_simulacion.start();			
		
		control.start();
		monitor.start();
		add(panelB);		
		add(panelE);
		setVisible(true);
		destroy();
	}
	public Simulacion getSimulacion(){
		return this.simulacion;
	}
}