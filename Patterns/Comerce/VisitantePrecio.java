
public class VisitantePrecio implements VisitanteEquipo{
	
	private double precioDisco;
	private double precioTarjeta;
	private double precioBus;
	
	public VisitantePrecio(){
		precioDisco = 0.0;
		precioTarjeta = 0.0;
		precioBus = 0.0;
	}
	
	public double getPrecioDisco(){
		return precioDisco;
	}
	
	public double getPrecioTarjeta(){
		return precioTarjeta;
	}
	
	public double getPrecioBus(){
		return precioBus;
	}
	
	public double getPrecioTotal(){
		return precioDisco + precioTarjeta + precioBus;
	}
	
	@Override
	public void visitarDisco(Disco d) {
		precioDisco = d.getPrecioNeto();
	}

	@Override
	public void visitarTarjeta(Tarjeta t) {
		precioTarjeta = t.getPrecioNeto();
	}

	@Override
	public void visitarBus(Bus b) {
		precioBus = b.getPrecioNeto();
	}

}
