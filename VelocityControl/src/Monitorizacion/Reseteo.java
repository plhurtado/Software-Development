/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package Monitorizacion;
import ControlVelocidad.Eje;
public class Reseteo {
		protected void inicializarValores(CalculadorVelMed velMed, Eje eje) {
		eje.resetear();
		velMed.resetearTiempo();
	}
}