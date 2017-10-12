
public class GestorFiltros {

private CadenaFiltros cadenaFiltros;

	public GestorFiltros(Interfaz unObjetivo){
		cadenaFiltros = new CadenaFiltros(unObjetivo);
	}

	public void setFiltro(Filtro unFiltro){
		cadenaFiltros.addFiltro(unFiltro);
	}

	public void peticionFiltro(double unaPeticion){
		cadenaFiltros.ejecutar(unaPeticion);
	}
}
