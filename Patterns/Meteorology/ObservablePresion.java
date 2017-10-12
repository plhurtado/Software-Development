
public class ObservablePresion extends Observable{

	private double presion;
	private static ObservablePresion instancia = new ObservablePresion();
	
	private ObservablePresion(){
		this.presion = 2.0;
	}
	
	public static ObservablePresion getInstancia(){
		return instancia;
	}
	
	public double getPresion(){
		return this.presion;
	}
	
	public void setPresion(double presion){
		this.presion = presion;
	}

}
