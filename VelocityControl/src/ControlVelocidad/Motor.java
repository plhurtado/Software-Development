/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package ControlVelocidad;
public class Motor {
	private boolean _estado;
	public Motor() {
		_estado = false;
	}
	public boolean leerEstado() {
		return _estado;
	}
	public void cambiarEstado() {
		if(_estado == false){
			_estado = true;
		}
		else{
			_estado = false;
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (_estado ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Motor))
			return false;
		Motor other = (Motor) obj;
		if (_estado != other._estado)
			return false;
		return true;
	}
	
}