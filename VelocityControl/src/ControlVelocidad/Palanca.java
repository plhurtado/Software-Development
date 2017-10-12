/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package ControlVelocidad;
public class Palanca {
	private int estado;
	public static final int APAGADO = 0;
	public static final int REINICIANDO = 1;
	public static final int MANTENIENDO = 2;
	public Palanca() {
		estado = 0;
	}
	public void cambiarEstado(int aInt_p) {
		estado = aInt_p;
	}
	public int leerEstado() {
		return estado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + estado;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Palanca))
			return false;
		Palanca other = (Palanca) obj;
		if (estado != other.estado)
			return false;
		return true;
	}
	
}