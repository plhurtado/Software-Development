
public class Bus extends Equipo{

	private double velocidad;
	private double precio;
	
	public Bus (String nombre, double velocidad, double precio){
		super(nombre);
		this.velocidad = velocidad;
		this.precio = precio;
	}
	
	@Override
	public double getPotencia(){
		return this.velocidad;
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
	public void aceptarVisitante(VisitanteEquipo ve) {
		ve.visitarBus(this);
	}
}
