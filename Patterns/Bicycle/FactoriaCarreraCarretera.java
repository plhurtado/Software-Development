
import java.util.ArrayList;

public class FactoriaCarreraCarretera implements Carrera{
	
	@Override
	public ArrayList<Bicicleta> CrearCarrera (int participantes){
		ArrayList<Bicicleta> array = new ArrayList<Bicicleta>();
		
		for (int i=0; i<participantes; i++)
			array.add(new BicicletaCarretera());
		
		return array;
	}

}
