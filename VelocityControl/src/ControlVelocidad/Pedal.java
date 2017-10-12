/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package ControlVelocidad;

public interface Pedal{
	public  void actualizar(int valor, Eje eje);
	public  double actualizarPedal(double valor);
	public void soltarPedal();
	public boolean leerEstado();
	public void pisarPedal();
}
