/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package ControlVelocidad;
public final class Eje {
	public final double RADIO = 0.8;
	private int vueltas;
	private long vueltasTotales;
	private CalculadorVel calculadorVel;
	public final int MAXVUELTAS = 10000 ;
	public int velAnterior;
	public Eje() {
		calculadorVel = new CalculadorVel();
		vueltas = 0;
		vueltasTotales = 0;
	}
	synchronized public int getVelocidadAnterior(){
		return velAnterior;
	}
	synchronized public void incrementarVueltas(int aumento) {
		if(vueltas<=MAXVUELTAS || aumento<0){
			vueltas += aumento;
			if(vueltas < 0){
				vueltas = 0;
			}
		}
	}
	synchronized public void resetear() {
		vueltasTotales = 0;
	}

	synchronized public int leerRevoluciones() {
		return vueltas;
	}
	synchronized public long leerRevolucionesTotales() {
		return vueltasTotales;
	}
	synchronized public void calcularVelocidad(Almacenamiento almacena){
		velAnterior = calculadorVel.calcularVelocidad(vueltas, RADIO, almacena);
		vueltasTotales += vueltas/24;
	}
	
	public CalculadorVel getCalculador(){
		return calculadorVel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + MAXVUELTAS;
		long temp;
		temp = Double.doubleToLongBits(RADIO);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((calculadorVel == null) ? 0 : calculadorVel.hashCode());
		result = prime * result + velAnterior;
		result = prime * result + vueltas;
		result = prime * result + (int) (vueltasTotales ^ (vueltasTotales >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Eje))
			return false;
		Eje other = (Eje) obj;
		if (MAXVUELTAS != other.MAXVUELTAS)
			return false;
		if (Double.doubleToLongBits(RADIO) != Double.doubleToLongBits(other.RADIO))
			return false;
		if (calculadorVel == null) {
			if (other.calculadorVel != null)
				return false;
		} else if (!calculadorVel.equals(other.calculadorVel))
			return false;
		if (velAnterior != other.velAnterior)
			return false;
		if (vueltas != other.vueltas)
			return false;
		if (vueltasTotales != other.vueltasTotales)
			return false;
		return true;
	}
	
}