
import java.util.ArrayList;

public class Simulacion extends Thread{

	//Atributos
	ArrayList <Bicicleta> bicicletas;
	TC tipo;
	Carrera factoria;
	int participantes;

	//Constructor
	public Simulacion (TC tipo, int participantes){
		this.bicicletas = new ArrayList<Bicicleta>();
		this.tipo = tipo;
		this.participantes = participantes;
		
		if (tipo == TC.CARRETERA)
			factoria = new FactoriaCarreraCarretera();
		else
			factoria = new FactoriaCarreraMontana();
		
	}
	
	//Metodos
	public void empezarCarrera(){
		double porcentajeRetirados = 0;
		int abandonos = 0;
		int momentoAbandono = 0;
		int azar = 0;
		int aux = 0;
		
		if (this.tipo == TC.CARRETERA)
			porcentajeRetirados = 0.1;
		else
			porcentajeRetirados = 0.2;
		
		abandonos = (int)(participantes * porcentajeRetirados);
		
		//Comienzo de la carrera
		System.out.println("Comienza la carrera de bicicletas de " + tipo.toString() + ". Participan " + participantes + " ciclistas.");
		
		momentoAbandono = (int)(Math.random()*59999);
		long inicio = System.currentTimeMillis();
		long transcurrido = System.currentTimeMillis();
		
		while (transcurrido - inicio < 60000){

			if (transcurrido - inicio == momentoAbandono){
				while(aux < abandonos){
					azar = (int)((Math.random()*bicicletas.size()));
					bicicletas.remove(azar);
					aux++;
					System.out.println("La bicicleta de  " + tipo.toString() + " número " + azar + " abandona la carrera.");
				}
			}
			
			transcurrido = System.currentTimeMillis();
		}
		
		System.out.println("La carrera de bicicletas de " + tipo.toString() + " ha finalizado con " + abandonos + " abandonos.");
				
	}
	
	@Override
	public void run(){
		
		if(tipo != null){
			bicicletas = factoria.CrearCarrera(participantes);
			empezarCarrera();
		}
		else{
			System.out.println("No hay un tipo definido de carrera");
		}
	}
}
