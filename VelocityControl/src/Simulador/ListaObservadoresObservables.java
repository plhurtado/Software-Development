/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package Simulador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaObservadoresObservables extends Observable{
	private List<Observador> observadores;
	public Map<Observador, List<Object>> eventos;
	
	public ListaObservadoresObservables(){
		observadores = new ArrayList<Observador>();
		eventos = new HashMap<Observador, List<Object>>();
	}
	
	public void aniadirObservador(Observador o){
		observadores.add(o);
		eventos.put(o, new ArrayList<Object>());
	}
	
	public void eliminarObservador(Observador o){
		observadores.remove(o);
		eventos.remove(o);
	}
	
	public List<Observador> getObservadores(){
		return observadores;
	}
	
	public void notificarObservadores(){
		for(Observador o : observadores){
			o.actualizar();
		}
	}
	public Map<Observador, List<Object>> getEventosProducidos(){
		return eventos;
	}
}
