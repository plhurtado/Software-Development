
public class ObservableTemperatura extends Observable{

	private double temperatura;
	private static ObservableTemperatura instancia = new ObservableTemperatura();
	
	private ObservableTemperatura(){
		this.temperatura = 15.0;
	}
	
	public static ObservableTemperatura getInstancia(){
		return instancia;
	}
	
	public double getTemperatura(){
		return this.temperatura;
	}
	
	public void setTemperatura(double temperatura){
		this.temperatura = temperatura;
	}
}
