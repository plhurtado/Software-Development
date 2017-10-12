/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package ControlVelocidad;
public class CalculadorVel {
	protected void almacenarVelocidad(int Int_velocidad, Almacenamiento almacena) {
		almacena.almacenarVelocidad(Int_velocidad);
	}
	protected int calcularVelocidad(int vueltas, double radio, Almacenamiento almacena) {
		int v = 0;
		v= (int) (vueltas*radio)/40;
		almacena.almacenarVelocidad(v);
		return v;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CalculadorVel))
			return false;
		return true;
	}
}