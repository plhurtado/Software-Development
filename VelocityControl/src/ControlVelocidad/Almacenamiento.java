/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package ControlVelocidad;
public class Almacenamiento {
	private int velocidad;
	private double distancia;
	private int _seleccionada;
	
	public boolean almacenar_called = false;
	
	protected Almacenamiento() {
		velocidad = 0;
		distancia = 0.0;
		_seleccionada = 0;
	}
	synchronized protected void almacenarVelocidad(int aInt_velActual) {
		velocidad=aInt_velActual;
		almacenarDistancia();
		almacenar_called = true;
	}
	synchronized protected int leerVelocidad() {
		return velocidad;	
	}
	synchronized protected void almacenarDistancia() {
		if(velocidad*0.25 > 1){
			distancia += (velocidad*0.25)/(3600); 
		}		
	}
	synchronized protected double leerDistancia() {
		return distancia;	
	}
	synchronized protected void almacenarVelSeleccionada() {
		_seleccionada = velocidad;
	}
	synchronized protected int leerVelSeleccionada() {
		return _seleccionada;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _seleccionada;
		long temp;
		temp = Double.doubleToLongBits(distancia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + velocidad;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Almacenamiento))
			return false;
		Almacenamiento other = (Almacenamiento) obj;
		if (_seleccionada != other._seleccionada)
			return false;
		if (Double.doubleToLongBits(distancia) != Double.doubleToLongBits(other.distancia))
			return false;
		if (velocidad != other.velocidad)
			return false;
		return true;
	}
	
}