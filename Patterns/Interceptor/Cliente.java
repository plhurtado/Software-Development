
public class Cliente {

	private GestorFiltros gestorFiltros;
	
	public Cliente(GestorFiltros gestorFiltros){
		this.gestorFiltros = gestorFiltros;
	}
	
	public void setGestorFiltros(GestorFiltros gestorFiltros){
		this.gestorFiltros = gestorFiltros;
	}

	public void enviarPeticion(double peticion){
		gestorFiltros.peticionFiltro(peticion);
	}

}
