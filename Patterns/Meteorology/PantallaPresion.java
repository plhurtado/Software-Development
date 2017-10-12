
public class PantallaPresion implements Observador{
	
	private double presion;
	
	public PantallaPresion(){
		presion = ObservablePresion.getInstancia().getPresion();
		ObservablePresion.getInstancia().incluirObservador(this);
	}
	
	public double getPresion(){
		return this.presion;
	}
	
	public void manejarEvento(){
		presion = ObservablePresion.getInstancia().getPresion();
	}

}
