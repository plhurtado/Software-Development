import java.util.Calendar;
import java.util.GregorianCalendar;

public class Pantalla implements Runnable{
	

	private PantallaTemperatura pantallaTemperatura;
	private PantallaHumedad pantallaHumedad;
	private PantallaPresion pantallaPresion;
	
	public Pantalla(){
		
		//Se inicializan los observadores
		pantallaTemperatura = new PantallaTemperatura();
		pantallaHumedad = new PantallaHumedad();
		pantallaPresion = new PantallaPresion();
	
	}
	
	@Override
	public void run(){

		while(true){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			refrescarPantalla();
		}
	}
	
	private void refrescarPantalla(){
		Calendar calendario = new GregorianCalendar();
		int hora =calendario.get(Calendar.HOUR_OF_DAY);
		int minutos = calendario.get(Calendar.MINUTE);
		int segundos = calendario.get(Calendar.SECOND);
		System.out.println("Los valores a las " + hora + ":" + minutos + ":" + segundos + " horas son:");
		System.out.println("Temperatura: " + pantallaTemperatura.getTemperatura());
		System.out.println("Humedad: " + pantallaHumedad.getHumedad());
		System.out.println("Presion: " + pantallaPresion.getPresion());
	}
	
}
