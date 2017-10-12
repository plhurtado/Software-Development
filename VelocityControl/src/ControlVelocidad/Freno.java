/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package ControlVelocidad;
public class Freno implements Pedal{
	private boolean _estado;
	private final int desaceleracion=700;
	public static final int ROZAMIENTO=100;
	public Freno() {
		_estado = false;
	}
	public void actualizar(int desaceleracion, Eje eje) {	
		eje.incrementarVueltas(-desaceleracion);
	}
	public double actualizarPedal(double d) {
		return desaceleracion + ROZAMIENTO;
	}
	public void soltarPedal() {
		_estado = false;
	}
	public void pisarPedal() {
		_estado = true; 
	}
	public boolean leerEstado() {
		return _estado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (_estado ? 1231 : 1237);
		result = prime * result + desaceleracion;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Freno))
			return false;
		Freno other = (Freno) obj;
		if (_estado != other._estado)
			return false;
		if (desaceleracion != other.desaceleracion)
			return false;
		return true;
	}
}