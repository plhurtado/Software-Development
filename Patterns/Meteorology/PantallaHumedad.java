
public class PantallaHumedad implements Observador{
	
	private double humedad;
	
	public PantallaHumedad (){
		humedad = ObservableHumedad.getInstancia().getHumedad();
		ObservableHumedad.getInstancia().incluirObservador(this);
	}

	public double getHumedad(){
		return this.humedad;
	}
	
	public void manejarEvento(){
		humedad = ObservableHumedad.getInstancia().getHumedad();
	}
}
