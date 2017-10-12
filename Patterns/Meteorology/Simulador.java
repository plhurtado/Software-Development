import java.util.Calendar;

public class Simulador extends Thread{
	
	private double t_1;
	private double t_2;
	
	public Simulador(){
		Calendar calendario = Calendar.getInstance();
		int mes = calendario.get(Calendar.MONTH);
	
		t_1 = calculaMenor(mes);
		t_2 = calculaMayor(mes);
	}
	
	private int calculaMenor(int mes){
		if(mes <= 1)
			return -4;
		else if(mes >= 2 && mes <= 4)
			return 7;
		else if(mes >= 6 && mes <= 9)
			return 20;
		else 
			return 15;
	}
	
	private int calculaMayor(int mes){
		if(mes <= 1)
			return 12;
		else if(mes >= 2 && mes <= 4)
			return 20;
		else if(mes >= 6 && mes <= 9)
			return 40;
		else 
			return 22;
	}
	
	@Override
	public void run(){

		double temperatura;
		double humedad;
		double presion;
		
		while (true){
			
			temperatura = Math.floor(Math.random()*(t_2-t_1+1)+t_1);
			humedad = Math.random()*100;
			presion = (int)(Math.random()*5);
			
			try{
				sleep(10000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}

			ObservableTemperatura.getInstancia().setTemperatura(temperatura);
			ObservableTemperatura.getInstancia().notificarObservador();
			ObservableHumedad.getInstancia().setHumedad(humedad);
			ObservableHumedad.getInstancia().notificarObservador();
			ObservablePresion.getInstancia().setPresion(presion);
			ObservablePresion.getInstancia().notificarObservador();
		}
	}
}
