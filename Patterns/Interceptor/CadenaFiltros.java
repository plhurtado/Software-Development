import java.util.ArrayList;

public class CadenaFiltros {
	
	private ArrayList <Filtro> filtros;
	Interfaz objetivo;
	
	public CadenaFiltros(Interfaz objetivo){
		filtros = new ArrayList<Filtro>();
		this.objetivo = objetivo;
	}
	
	public void ejecutar(double peticion){
		for (int i=0; i<filtros.size(); i++)
			filtros.get(i).ejecutar(peticion);
		objetivo.ejecutar(peticion);
	}
	
	public void setObjetivo (Interfaz objetivo){
		this.objetivo = objetivo;
	}
	
	public void addFiltro (Filtro filtro){
		filtros.add(filtro);
	}
}
