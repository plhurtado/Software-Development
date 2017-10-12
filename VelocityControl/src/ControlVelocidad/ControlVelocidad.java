/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package ControlVelocidad;
public class ControlVelocidad {
	public Acelerador acelera;
	public Almacenamiento almacena;
	public Eje eje;
	public Freno freno;
	public Motor motor;
	public Palanca estadoPalanca;
	private Reloj reloj;
	private Automatico automatico;
	private int tiempo;
	
	/* flags de pruebas unitarias */
	public boolean encendido_apagada_acelerando = false;
	public boolean encendido_apagada_frenando = false;
	public boolean encendido_apagada_rozamiento = false;
	public boolean encendido_manteniendo = false;
	public boolean encendido_reiniciando = false;
	public boolean apagado_frenando = false;
	public boolean apagado = false;
	/* fin flags */
	
	public ControlVelocidad() {
		acelera = new Acelerador();
		almacena = new Almacenamiento();
		automatico = new Automatico();
		eje = new Eje();
		freno = new Freno();
		motor = new Motor();
		estadoPalanca = new Palanca();
		reloj = new Reloj(this);
		tiempo = 0;
	}
	public Automatico getAutomatico(){
		return automatico;
	}
	public Reloj getReloj(){
		return reloj;
	}
	public void start(){
		reloj.start();
	}
	public void controlarEstado() {
		int incremento=0, decremento=0;
		tiempo += reloj.getIntervalo();
		
		if(motor.leerEstado()){
			if(estadoPalanca.leerEstado() == Palanca.APAGADO){
				if(acelera.leerEstado()){
					incremento = (int) acelera.actualizarPedal(eje.velAnterior);
					acelera.actualizar(incremento, eje);
					calcularVelcidad();
					encendido_apagada_acelerando = true;
				}
				if(freno.leerEstado()){
					decremento = (int) freno.actualizarPedal((double)0.0);
					freno.actualizar(decremento, eje);
					calcularVelcidad();
					encendido_apagada_frenando = true;
				}
				if(!acelera.leerEstado() && !freno.leerEstado()){
					freno.actualizar(Freno.ROZAMIENTO, eje);
					calcularVelcidad();
					encendido_apagada_rozamiento = true;
				}
			}
			if(estadoPalanca.leerEstado() == Palanca.MANTENIENDO){
				almacena.almacenarVelSeleccionada();
				automatico.mantenerVelocidad(acelera, freno,almacena, eje);
				calcularVelcidad();
				encendido_manteniendo = true;
			}
			if(estadoPalanca.leerEstado() == Palanca.REINICIANDO){
				automatico.mantenerVelocidad(acelera, freno, almacena, eje);
				calcularVelcidad();	
				encendido_reiniciando = true;
			}
		}
		else{
			if(freno.leerEstado()){
				decremento = (int) freno.actualizarPedal(0.0);
				freno.actualizar(decremento, eje);
				calcularVelcidad();
				apagado_frenando = true;
			}
			freno.actualizar(Freno.ROZAMIENTO, eje);
			calcularVelcidad();
			apagado = true;
		}
	}
	public void cambiarPalanca(int aInt_estado) {
		estadoPalanca.cambiarEstado(aInt_estado);
	}
	public int obtenerVel(){
		return almacena.leerVelocidad();		
	}
	public double obtenerDist(){
		return almacena.leerDistancia();
	}
	public int obtenerRev(){
		return eje.leerRevoluciones();	
	}
	public long obtenerRevtotal(){
		return eje.leerRevolucionesTotales();	
	}
	
	protected void calcularVelcidad(){
		eje.calcularVelocidad(almacena);
	}
	public int leerVelSeleccionada() {
		return almacena.leerVelSeleccionada();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acelera == null) ? 0 : acelera.hashCode());
		result = prime * result + ((almacena == null) ? 0 : almacena.hashCode());
		result = prime * result + ((automatico == null) ? 0 : automatico.hashCode());
		result = prime * result + ((eje == null) ? 0 : eje.hashCode());
		result = prime * result + ((estadoPalanca == null) ? 0 : estadoPalanca.hashCode());
		result = prime * result + ((freno == null) ? 0 : freno.hashCode());
		result = prime * result + ((motor == null) ? 0 : motor.hashCode());
		result = prime * result + ((reloj == null) ? 0 : reloj.hashCode());
		result = prime * result + tiempo;
		return result;
	}
	
	public int getTiempo() {
		return tiempo;
	}
	public void incrementaTiempo(int intervalo){
		tiempo += intervalo;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ControlVelocidad))
			return false;
		ControlVelocidad other = (ControlVelocidad) obj;
		if (acelera == null) {
			if (other.acelera != null)
				return false;
		} else if (!acelera.equals(other.acelera))
			return false;
		if (almacena == null) {
			if (other.almacena != null)
				return false;
		} else if (!almacena.equals(other.almacena))
			return false;
		if (automatico == null) {
			if (other.automatico != null)
				return false;
		} else if (!automatico.equals(other.automatico))
			return false;
		if (eje == null) {
			if (other.eje != null)
				return false;
		} else if (!eje.equals(other.eje))
			return false;
		if (estadoPalanca == null) {
			if (other.estadoPalanca != null)
				return false;
		} else if (!estadoPalanca.equals(other.estadoPalanca))
			return false;
		if (freno == null) {
			if (other.freno != null)
				return false;
		} else if (!freno.equals(other.freno))
			return false;
		if (motor == null) {
			if (other.motor != null)
				return false;
		} else if (!motor.equals(other.motor))
			return false;
		if (tiempo != other.tiempo)
			return false;
		return true;
	}
	
	public Almacenamiento getAlmacen(){
		return this.almacena;
	}
	public Eje getEje(){
		return this.eje;
	}
}