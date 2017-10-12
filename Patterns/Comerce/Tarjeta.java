
public class Tarjeta extends Equipo{

	private double capacidad;
	private double precio;
	
	public Tarjeta (String nombre, double capacidad, double precio){
		super(nombre);
		this.capacidad = capacidad;
		this.precio = precio;
	}
	
	@Override
	public double getPotencia(){
		return this.capacidad;
	}
	
	@Override
	public double getPrecioNeto(){
		return this.precio;
	}
	
	@Override
	public double getPrecioDescuento(TipoCliente tipo){
		if(tipo == TipoCliente.VIP)
			return precio-((precio*10.0)/100.0);
		else if(tipo == TipoCliente.MAYORISTA)
			return precio-((precio*15.0)/100.0);
		else return this.precio;
	}
	
	@Override
	public void aceptarVisitante(VisitanteEquipo ve){
		ve.visitarTarjeta(this);
	}
}
