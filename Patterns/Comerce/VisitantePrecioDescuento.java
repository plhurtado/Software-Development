
public class VisitantePrecioDescuento implements VisitanteEquipo{
	
	private double precioDiscoDescuento;
	private double precioTarjetaDescuento;
	private double precioBusDescuento;
	TipoCliente tipo;
	private int numeroConsultas;
	
	public VisitantePrecioDescuento(TipoCliente tipo){
		this.precioBusDescuento = 0.0;
		this.precioDiscoDescuento = 0.0;
		this.precioTarjetaDescuento = 0.0;
		this.tipo = tipo;
		this.numeroConsultas = 0;
	}
	
	public double getPrecioDiscoDescuento(){
		return this.precioDiscoDescuento;
	}
	
	public double getPrecioTarjetaDescuento(){
		return this.precioTarjetaDescuento;
	}
	
	public double getPrecioBusDescuento(){
		return this.precioBusDescuento;
	}
	
	public double getPrecioTotalDescuento(){
		double precio = precioDiscoDescuento + precioTarjetaDescuento + precioBusDescuento;
		return precio;
	}
	
	@Override
	public void visitarDisco(Disco d) {
		precioDiscoDescuento = d.getPrecioDescuento(tipo);
		if(numeroConsultas >= 25){
			precioDiscoDescuento = precioDiscoDescuento - ((precioDiscoDescuento*5)/100);
		}
	}

	@Override
	public void visitarTarjeta(Tarjeta t) {
		precioTarjetaDescuento = t.getPrecioDescuento(tipo);
		if(numeroConsultas >= 25){
			precioTarjetaDescuento = precioTarjetaDescuento - ((precioTarjetaDescuento*5)/100);
		}
	}

	@Override
	public void visitarBus(Bus b) {
		precioBusDescuento = b.getPrecioDescuento(tipo);
		if(numeroConsultas >= 25){
			precioBusDescuento = precioBusDescuento - ((precioBusDescuento*5)/100);
		}
	}
}
