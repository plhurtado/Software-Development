/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package Simulador;

public class ObservadorTestListener implements Observador{
	private Interfaz interfaz;
	ObservadorTestListener(Interfaz interfaz){
		this.interfaz = interfaz;
	}
	@Override
	public void actualizar() {
		interfaz.getSimulacion().getEventosProducidos().get(this).add("ActualizarObservadorTest");
	}
	
}
