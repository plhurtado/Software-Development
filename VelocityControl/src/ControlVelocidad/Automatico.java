/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package ControlVelocidad;
public class Automatico {
	public void mantenerVelocidad(Acelerador aAcelerador_a, Freno freno, Almacenamiento aAlmacenamiento_al, Eje eje) {		
		if(aAlmacenamiento_al.leerVelocidad() > aAlmacenamiento_al.leerVelSeleccionada()){
			freno.actualizar(300, eje); 
		}
		if(aAlmacenamiento_al.leerVelocidad() < aAlmacenamiento_al.leerVelSeleccionada()){
			aAcelerador_a.actualizar(300, eje); 
		}
		if(aAlmacenamiento_al.leerVelocidad() == aAlmacenamiento_al.leerVelSeleccionada()){
			aAcelerador_a.actualizar(0, eje);
		}
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Automatico))
			return false;
		return true;
	}
}