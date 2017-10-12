
public class VisitanteNombre implements VisitanteEquipo{
	private String nombreDisco;
	private String nombreBus;
	private String nombreTarjeta;
	
	public VisitanteNombre(){
		this.nombreBus = new String();
		this.nombreDisco = new String();
		this.nombreTarjeta = new String();
	}
	
	public String getNombreDisco(){
		return nombreDisco;
	}
	
	public String getNombreTarjeta(){
		return nombreTarjeta;
	}
	
	public String getNombreBus(){
		return nombreBus;
	}
	
	@Override
	public void visitarDisco(Disco d) {
		nombreDisco = d.getNombre(); 
	}

	@Override
	public void visitarTarjeta(Tarjeta t) {
		nombreTarjeta = t.getNombre();
	}

	@Override
	public void visitarBus(Bus b) {
		nombreBus = b.getNombre();
	}

}
