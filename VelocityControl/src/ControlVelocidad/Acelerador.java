/*
 Implementado por:
 Pedro Hurtado Gozález
*/

package ControlVelocidad;

public class Acelerador implements Pedal{
	private boolean _estado;
	private final int aceleracion=300;
	public static final int ROZAMIENTO=100;
	public Acelerador() {
		_estado = false;
	}
	public void actualizar(int aceleracion, Eje eje) {	
		eje.incrementarVueltas(aceleracion);
	}
	public double actualizarPedal(double velAnterior) {
		return (aceleracion - (ROZAMIENTO*0.015*velAnterior));
	}
	public void soltarPedal() {
		_estado = false;
	}
	public boolean leerEstado() {
		return _estado;
	}
	public void pisarPedal() {
		_estado = true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (_estado ? 1231 : 1237);
		result = prime * result + aceleracion;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Acelerador))
			return false;
		Acelerador other = (Acelerador) obj;
		if (_estado != other._estado)
			return false;
		if (aceleracion != other.aceleracion)
			return false;
		return true;
	}

}