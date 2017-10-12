
public class ObservableHumedad extends Observable{

	private double humedad;
	private static ObservableHumedad instancia = new ObservableHumedad();
	
	private ObservableHumedad(){
		this.humedad = 30.2;
	}
	
	public static ObservableHumedad getInstancia(){
		return instancia;
	}
	
	public double getHumedad(){
		return this.humedad;
	}
	
	public void setHumedad(double humedad){
		this.humedad = humedad;
	}

}
