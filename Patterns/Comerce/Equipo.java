
public abstract class Equipo {

	private String nombre;
	
	public Equipo (String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public abstract double getPotencia();
	
	public abstract double getPrecioNeto();
	
	public abstract double getPrecioDescuento(TipoCliente tipo);
	
	public abstract void aceptarVisitante (VisitanteEquipo ve);
}
