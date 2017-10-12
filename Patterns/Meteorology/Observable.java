
import java.util.ArrayList;
public abstract class Observable {

	private ArrayList<Observador> observadores = new ArrayList<Observador>();
	
	public void incluirObservador(Observador o){
		observadores.add(o);
	}
	
	public void notificarObservador(){
		for (int i=0; i<observadores.size(); i++)
			observadores.get(i).manejarEvento();
	}
}
