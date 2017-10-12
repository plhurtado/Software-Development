
public class CalcularDistancia implements Filtro{
	
	@Override
	public double ejecutar (Object objeto){
		double revoluciones = (double) objeto;
		double distancia = revoluciones*0.2513;
		System.out.println("Se han recorrido " + distancia + " metros");
		return distancia;
	}
	
}
