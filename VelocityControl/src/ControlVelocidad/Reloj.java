/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package ControlVelocidad;
public class Reloj extends Thread {
	private final int INTERVALO = 250;
	private ControlVelocidad control;
	public Reloj(ControlVelocidad ControlVelocidad_c) {
		this.control = ControlVelocidad_c;
	}
	public ControlVelocidad getControlVelocidad(){
		return this.control;
	}
	public int getIntervalo(){
		return INTERVALO;
	}
	public void run() {
		while(true){
			try{ 
				sleep(INTERVALO);
			}catch(java.lang.InterruptedException e){e.printStackTrace();}	
			control.controlarEstado();
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + INTERVALO;
		result = prime * result + ((control == null) ? 0 : control.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Reloj))
			return false;
		Reloj other = (Reloj) obj;
		if (INTERVALO != other.INTERVALO)
			return false;
		if (control == null) {
			if (other.control != null)
				return false;
		} else if (!control.equals(other.control))
			return false;
		return true;
	}
	
}