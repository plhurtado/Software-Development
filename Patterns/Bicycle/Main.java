
public class Main {

	public static void main (String[] args){
		Simulacion simulacionMontana = new Simulacion(TC.MONTANA, 30);
		Simulacion simulacionCarrera = new Simulacion(TC.CARRETERA, 30);
		
		simulacionMontana.start();
		simulacionCarrera.start();
	}
}
