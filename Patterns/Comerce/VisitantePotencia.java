
public class VisitantePotencia implements VisitanteEquipo{
	
	private double potenciaDisco;
	private double potenciaBus;
	private double potenciaTarjeta;
	
	public VisitantePotencia(){
		potenciaDisco = 0.0;
		potenciaBus = 0.0;
		potenciaTarjeta = 0.0;
	}
	
	public double getPotenciaDisco(){
		return this.potenciaDisco;
	}
	
	public double getPotenciaBus(){
		return this.potenciaBus;
	}
	
	public double getPotenciaTarjeta(){
		return this.potenciaTarjeta;
	}

	public double getNombreDisco(){
		return this.potenciaDisco;
	}
	
	public double getNombreTarjeta(){
		return this.potenciaTarjeta;
	}
	
	public double getNombreBus(){
		return this.potenciaBus;
	}
	
	@Override
	public void visitarDisco(Disco d) {
		potenciaDisco = d.getPotencia();
	}

	@Override
	public void visitarTarjeta(Tarjeta t) {
		potenciaTarjeta = t.getPotencia();
	}

	@Override
	public void visitarBus(Bus b) {
		potenciaBus = b.getPotencia();
	}
}
