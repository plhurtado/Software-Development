
public class PantallaTemperatura implements Observador{

	private double temperatura;
	
	public PantallaTemperatura(){
		temperatura = ObservableTemperatura.getInstancia().getTemperatura();
		ObservableTemperatura.getInstancia().incluirObservador(this);
	}
	
	public double getTemperatura(){
		return this.temperatura;
	}
	
	public void manejarEvento(){
		temperatura = ObservableTemperatura.getInstancia().getTemperatura();
	}
}
