
public class CalcularVelocidad implements Filtro{

	@Override
	public double ejecutar (Object objeto){
		double revoluciones = (double) objeto;
		double distancia = revoluciones*0.2513;
		double velocidad = distancia/10;
		System.out.println("Velocidad: "+(velocidad*3600/1000)+" k/h");
		return velocidad;
	}
}
