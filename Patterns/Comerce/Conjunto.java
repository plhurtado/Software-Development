
public class Conjunto {

	private String nombre;
	private Disco disco;
	private Bus bus;
	private Tarjeta tarjeta;
	
	public Conjunto (String nombre, Disco disco, Tarjeta tarjeta, Bus bus){
		this.nombre = nombre;
		this.disco = disco;
		this.bus = bus;
		this.tarjeta = tarjeta;
	}

	public String getNombre() {
		return nombre;
	}

	public Disco getDisco() {
		return disco;
	}

	public Bus getBus() {
		return bus;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	
}
